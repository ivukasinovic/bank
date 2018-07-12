import {Component, OnInit, TemplateRef} from '@angular/core';
import {Cenovnik, PDV, Proizvod, StavkaCenovnika, StopaPDV} from '../../model/model';
import {CenovnikService} from '../../service/cenovnik.service';
import {PdvService} from '../../service/pdv.service';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';

@Component({
  selector: 'app-dodaj-pdv',
  templateUrl: './dodaj-pdv.component.html',
  styleUrls: ['./dodaj-pdv.component.css']
})
export class DodajPdvComponent implements OnInit {
  pdv: PDV;
  modalRef: BsModalRef;
  stopaModal: StopaPDV[];
  stopaSelected: StopaPDV;
  pomStopa: StopaPDV;
  stopaSlanje: StopaPDV;
  naziv: string;
  constructor(private pdvService: PdvService, private modalService: BsModalService) {
    this.pdv = new PDV();
    this.pdv.stopaPDVList = [];
    this.stopaSelected = new StopaPDV();
    this.pomStopa = new StopaPDV();
    this.stopaSlanje = new StopaPDV();
  }

  ngOnInit() {
    this.pdvService.getStopaPDV().subscribe(
      (response: StopaPDV[]) => {
        this.stopaModal = response;
      },
      error2 => {
        alert( 'Nisu ucitane stope!');
      }
    );
  }

  // kreiraj(naziv: string) {
  //   this.pdv.naziv = naziv;
  //   console.log(this.pdv , ' i ' , this.pdv.naziv);
  //   this.pdvService.postPDV(this.pdv).subscribe(
  //     (response: any ) => {
  //       alert('Uspesno ste dodali PDV! ');
  //     },
  //     error1 => {
  //       alert('Greska pri dodavanju PDV-a!');
  //     });
  // }
  kreiraj(naziv: string) {
    this.pdv.naziv = naziv;
    console.log('tu sam 0');
    this.pdvService.postPDV(this.pdv).subscribe(
        (response: PDV ) => {
          let i, vel, idPDV;
          console.log('tu sam');
          vel = this.pdv.stopaPDVList.length;
          for (i = 0; i < vel; i++) {
            this.stopaSlanje = this.pdv.stopaPDVList.pop();
            this.stopaSlanje.pdv = null;
            console.log('ID OD PDVA: ' , this.stopaSlanje.pdv.id, 'i ', response.id)
            //idPDV = this.stopaSlanje.pdv.id;
            this.pdvService.postStopu(this.stopaSlanje, response.id).subscribe();
          }
          alert('Uspesno ste dodali PDV! ');
        },
        error1 => {
          alert('Greska pri dodavanju PDV-a!');
        });
  }
  ukloniStopu(stavka: StopaPDV) {
    this.pdv.stopaPDVList.forEach( function (value, index, array) {
      if ( value = stavka) {
        array.splice(index, 1);
      }
    });
  }
  dodajStopu() {
    console.log('jovanaa bravo', this.stopaSelected.id, this.stopaSelected, ' duzina ', this.stopaModal.length);
    for (let i = 0; i < this.stopaModal.length; i++) {
      console.log('poredi ',  +this.stopaSelected.id, 'i', this.stopaModal[i].id  );
      if (this.stopaModal[i].id === +this.stopaSelected.id) {
        console.log('nasao id :' + this.stopaModal[i].id);
        this.pomStopa = this.stopaModal[i];
        break;
      }
    }
    console.log('aaa', this.pomStopa);
    this.pdv.stopaPDVList.push(this.pomStopa);
    this.stopaSelected = new StopaPDV();
    this.modalRef.hide();

  }
  openModal (template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }

}
