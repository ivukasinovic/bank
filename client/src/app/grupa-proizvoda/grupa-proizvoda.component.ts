import {Component, OnInit, TemplateRef} from '@angular/core';
import {Router} from '@angular/router';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';
import {GrupaProizvodaService} from '../service/grupa-proizvoda.service';
import {GrupaProizvoda, PDV, StopaPDV} from '../model/model';
import {PdvService} from '../service/pdv.service';

@Component({
  selector: 'app-grupa-proizvoda',
  templateUrl: './grupa-proizvoda.component.html',
  styleUrls: ['./grupa-proizvoda.component.css']
})
export class GrupaProizvodaComponent implements OnInit {

  grupaProizvoda: GrupaProizvoda;
  pomGrupaProizvoda: GrupaProizvoda;
  grupeProizvoda: GrupaProizvoda[];
  modalRef: BsModalRef;
  sviPDV: PDV[];
  pdvId: number;
  constructor(private grupaProizvodaService: GrupaProizvodaService, private pdvService: PdvService, private router: Router,
              private modalService: BsModalService) {

    this.grupaProizvodaService.getGrupeProizvoda().subscribe(
      (response: GrupaProizvoda []) => {
        this.grupeProizvoda = response;

      }
    );
    this.pdvService.getAllPdv().subscribe(
      (response: PDV []) => {
        this.sviPDV = response;
      }
    );
  }

  ngOnInit() {
    this.grupaProizvoda =  new GrupaProizvoda();
    this.pomGrupaProizvoda =  new GrupaProizvoda();
    this.pdvId = 0;
  }

  openModal (template: TemplateRef<any>, grupaZaIzmenu: GrupaProizvoda) {
    this.modalRef = this.modalService.show(template);
    this.grupaProizvoda = grupaZaIzmenu;
  }
  openModalDodaj (template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }
  izmeniGrupu() {

    this.pomGrupaProizvoda.naziv = this.grupaProizvoda.naziv;
    this.pomGrupaProizvoda.opis = this.grupaProizvoda.opis;
    this.pomGrupaProizvoda.id = this.grupaProizvoda.id;
    console.log('pom Stopa:', this.pomGrupaProizvoda);
    for (let i = 0 ; i < this.sviPDV.length; i++ ) {
      if (this.sviPDV[i].naziv === this.grupaProizvoda.pdv) {
        this.pdvId = this.sviPDV[i].id;
      }
    }
    this.pomGrupaProizvoda.pdv = null;
    this.grupaProizvodaService.updateGrupaProizvodaWithPDVId(this.pomGrupaProizvoda, this.pdvId)
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
  brisiGrupu(grupa: GrupaProizvoda) {
    console.log('id  grupe za brisanje:', grupa.id);
    this.grupaProizvodaService.deleteGrupa(grupa.id)
      .subscribe(response => {
        alert('Uspesno ste obrisali!');
        window.location.reload();
        }, err => {
        alert('Niste uspeli obrisati!');
      });
  }
  DodajGrupu() {
    // postGrupaProizvoda
    this.pomGrupaProizvoda.naziv = this.grupaProizvoda.naziv;
    this.pomGrupaProizvoda.opis = this.grupaProizvoda.opis;
    /* this.pomGrupaProizvoda.id = this.grupaProizvoda.id;*/
    console.log('pom Stopa:', this.pomGrupaProizvoda);
    for (let i = 0 ; i < this.sviPDV.length; i++ ) {
      if (this.sviPDV[i].naziv === this.grupaProizvoda.pdv) {
        this.pdvId = this.sviPDV[i].id;
      }
    }
    this.pomGrupaProizvoda.pdv = null;
    this.grupaProizvodaService.postGrupaProizvoda(this.pomGrupaProizvoda, this.pdvId)
      .subscribe(response => {
          alert('Uspesno ste dodali!');
          window.location.reload();
        },
        err => {
          alert('Neuspesno dodavanje!');
        });
    // this.stopaSelected = new StopaPDV();
    this.modalRef.hide();

  }
}
