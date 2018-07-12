import {Component, OnInit, TemplateRef} from '@angular/core';
import {Cenovnik, Proizvod, StavkaCenovnika, Valuta} from '../../model/model';
import {CenovnikService} from '../../service/cenovnik.service';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';
import {Router} from '@angular/router';

@Component({
  selector: 'app-novi-cenovnik',
  templateUrl: './novi-cenovnik.component.html',
  styleUrls: ['./novi-cenovnik.component.css']
})
export class NoviCenovnikComponent implements OnInit {

  cenovnik: Cenovnik;

  valutaId: number;
  valute: Valuta[];
  modalRef: BsModalRef;
  proizvodi: Proizvod[];
  stavka: StavkaCenovnika;
  stavkeList: StavkaCenovnika[] = [];

  constructor(private cenovnikService: CenovnikService, private modalService: BsModalService, private router: Router) {
    this.cenovnik = new Cenovnik();
    this.cenovnik.datumVazenja = new Date();
    this.stavka = new StavkaCenovnika();
    this.stavka.proizvod = new Proizvod();
  }


  ngOnInit() {
    this.cenovnikService.getValute().subscribe(
      (response: Valuta[]) => {
        this.valute = response;
      },
      error2 => {
        alert('Nisu ucitane valute!');
      }
    );
    this.cenovnikService.getProizvodi().subscribe(
      (response: Proizvod[]) => {
        this.proizvodi = response;
      },
      error2 => {
        alert('Nisu ucitane proizvodi!');
      }
    );
  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }

  
  dodajStavku(stavka: StavkaCenovnika) {
     this.proizvodi.forEach( function (value, index, array) {
      if ( value.id == stavka.proizvod.id) {
        stavka.proizvod = value;
      }
    });

    this.stavkeList.push(this.stavka);
    this.stavka = new StavkaCenovnika();
    this.stavka.proizvod = new Proizvod();
    this.stavka.cena = 0;
    this.modalRef.hide();
  }

  ukloniStavku(stavka: StavkaCenovnika) {
    this.stavkeList.forEach(function (value, index, array) {
      if (value = stavka) {
        array.splice(index, 1);
      }
    });
  }

  kreiraj() {
    this.cenovnikService.postCenovnik(this.cenovnik, this.valutaId).subscribe(
      (response: Cenovnik) => {
        let i, idProizvoda, vel;
        vel = this.stavkeList.length;

        for (i = 0; i < vel; i++) {
          this.stavka = this.stavkeList.pop();
          idProizvoda = this.stavka.proizvod.id;
          this.stavka.proizvod = null;
          this.cenovnikService.postStavku(this.stavka, response.id, idProizvoda).subscribe();
        }

        alert('Done!');
        this.router.navigateByUrl('/home-page');
      },
      error1 => {
        alert('Nije uspjelo brisanje cenovnika!');
      });
  }
}
