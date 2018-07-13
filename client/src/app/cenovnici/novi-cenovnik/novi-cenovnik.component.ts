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
  valute: Valuta[] = [];
  modalRef: BsModalRef;
  proizvodi: Proizvod[];
  stavka: StavkaCenovnika;
  stavkeList: StavkaCenovnika[] = [];
  update = false;
  vel: number;
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

        if (localStorage.getItem('cenUpdate') != null) {
          this.update = true;
          this.cenovnik = JSON.parse(localStorage.getItem('cenUpdate'));
          localStorage.removeItem('cenUpdate');
          this.stavkeList = this.cenovnik.stavkaCenovnikaList;
          this.vel = this.stavkeList.length;
          let valutaOznaka, valIDTemp;
          valutaOznaka = this.cenovnik.valuta;
          this.valute.forEach( function (value, index, array) {
            if (valutaOznaka == value.oznaka) {
              valIDTemp = value.id;
            }
          });

          this.valutaId = valIDTemp;
          this.cenovnik.stavkaCenovnikaList = null;
          this.cenovnik.valuta = null;
          this.cenovnik.preduzece = null;
        }
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
      if (value === stavka) {
        stavka = value;
        array.splice(index, 1);
      }
    });

    if (this.update) {
      this.cenovnikService.obrisiStavku(stavka.id).subscribe();
      this.vel = this.vel - 1;

    }}

  kreiraj() {
    this.cenovnikService.postCenovnik(this.cenovnik, this.valutaId).subscribe(
      (response: Cenovnik) => {
        let i, idProizvoda;


        for (i = 0; i < this.stavkeList.length + 1; i++) {
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


  updateCen() {
    this.cenovnikService.postCenovnik(this.cenovnik, this.valutaId).subscribe(
      (response: Cenovnik) => {
        let i, idProizvoda;


        for (i = 0; i < this.stavkeList.length + 1; i++) {
          if (this.vel >= this.stavkeList.length) {
            this.update = false;
          }

          this.stavka = this.stavkeList.pop();


          if (this.update ) {
            idProizvoda = this.stavka.proizvod.id;
          } else {

            idProizvoda = this.stavka.proizvod;
            this.proizvodi.find(function (value, index, array) {
              if (value.naziv == idProizvoda) {
                idProizvoda = value.id;
                return true;
              }
            });
          }
          this.stavka.cenovnik = null;


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
