import {Component, OnInit, TemplateRef} from '@angular/core';
import {PDV, StopaPDV} from '../model/model';
import {Router} from '@angular/router';
import {PdvService} from '../service/pdv.service';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';

@Component({
  selector: 'app-stopa-pdv',
  templateUrl: './stopa-pdv.component.html',
  styleUrls: ['./stopa-pdv.component.css']
})
export class StopaPdvComponent implements OnInit {
  stopePdv: StopaPDV[];
  stopaPdv: StopaPDV;
  modalRef: BsModalRef;
  pomStopa: StopaPDV;
  pdvId: number;
  sviPDV: PDV[];
  constructor(private pdvService: PdvService, private router: Router, private modalService: BsModalService) {

    this.pdvService.getStopaPDV().subscribe(
      (response: StopaPDV []) => {
        this.stopePdv = response;
      }
    );

    this.pdvService.getAllPdv().subscribe(
      (response: PDV []) => {
        this.sviPDV = response;
      }
    );
  }

  ngOnInit() {
    this.stopaPdv = new StopaPDV();
    this.pomStopa = new StopaPDV();
  //  this.stopePdv = [];
  }

  openModal (template: TemplateRef<any>, stopaZaIzmenu: StopaPDV) {
    this.modalRef = this.modalService.show(template);
    this.stopaPdv = stopaZaIzmenu;
  }

  izmeniStopu(pdvObj: PDV, naziv: string, izmeniPdvPolje: string) {

    this.pomStopa.datumVazenja = this.stopaPdv.datumVazenja;
    this.pomStopa.stopa = this.stopaPdv.stopa;
    this.pomStopa.id = this.stopaPdv.id;
    console.log('pom Stopa:', this.pomStopa);
    for (let i = 0 ; i < this.sviPDV.length; i++ ) {
      if (this.sviPDV[i].naziv === this.stopaPdv.pdv) {
        this.pdvId = this.sviPDV[i].id;
      }
    }
    this.pomStopa.pdv = null;
      this.pdvService.updatePdvStopaWithPDVId(this.pomStopa, this.pdvId)
        .subscribe(response => {
            alert('Uspesno ste izmenili!');
            window.location.reload();
          },
          err => {
            alert('Niste uspeli izmenili!');
          });
   // this.stopaSelected = new StopaPDV();
    this.modalRef.hide();

  }
}
