import {Component, OnInit, TemplateRef} from '@angular/core';
import {Cenovnik, Proizvod, StavkaCenovnika, Valuta} from '../../model/model';
import {CenovnikService} from '../../service/cenovnik.service';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';

@Component({
  selector: 'app-novi-cenovnik',
  templateUrl: './novi-cenovnik.component.html',
  styleUrls: ['./novi-cenovnik.component.css']
})
export class NoviCenovnikComponent implements OnInit {

  cenovnik: Cenovnik;
  valute: Valuta[];
  modalRef: BsModalRef;
  proizvodi: Proizvod[];
  stavka: StavkaCenovnika;

  constructor( private cenovnikService: CenovnikService, private modalService: BsModalService) {
    this.cenovnik = new Cenovnik();
    this.cenovnik.stavkaCenovnikaList = [];
    this.stavka = new StavkaCenovnika();
  }



  ngOnInit() {
    this.cenovnikService.getValute().subscribe(
      (response: Valuta[]) => {
            this.valute = response;
      },
       error2 => {
          alert( 'Nisu ucitane valute!');
       }
    );
    this.cenovnikService.getProizvodi().subscribe(
      (response: Proizvod[]) => {
            this.proizvodi = response;
      },
       error2 => {
          alert( 'Nisu ucitane proizvodi!');
       }
    );
  }

  openModal (template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }

  dodajStavku() {
    console.log('jovanaa ', this.stavka.cena, this.stavka.proizvod);

    this.cenovnik.stavkaCenovnikaList.push(this.stavka);
    this.stavka = new StavkaCenovnika();
    this.modalRef.hide();
  }

  ukloniStavku(stavka: StavkaCenovnika) {
    this.cenovnik.stavkaCenovnikaList.forEach( function (value, index, array) {
      if ( value = stavka) {
        array.splice(index, 1);
      }
    });
  }

  kreiraj() {
    this.cenovnikService.postCenovnik(this.cenovnik).subscribe(
      (response: any ) => {
        alert('uspjeh!');
      },
      error1 => {
        alert('Nije uspjelo brisanje cenovnika!');
      });
  }
}
