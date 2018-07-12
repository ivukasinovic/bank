import { Component, OnInit } from '@angular/core';
import {Faktura, GrupaProizvoda, PDV} from '../model/model';
import {PdvService} from '../service/pdv.service';
import {Router} from '@angular/router';
import {FormGroup, FormControl, Validators, AbstractControl} from '@angular/forms';

@Component({
  selector: 'app-pdv',
  templateUrl: './pdv.component.html',
  styleUrls: ['./pdv.component.css']
})
export class PdvComponent implements OnInit {
  pdv: PDV[];
  pdvBezGrupe: PDV[];
  grupaProizvoda: GrupaProizvoda[];
  pdvIzmenjen: PDV;

  constructor(private pdvService: PdvService, private router: Router) {

    this.pdvService.getAllPdv().subscribe(
      (response: PDV []) => {
        this.pdv = response;
      }
    );
    this.pdvService.getGrupaProizvoda().subscribe(
      (response: GrupaProizvoda []) => {
        this.grupaProizvoda = response;
      }
    );
  }

  ngOnInit() {
  }

  brisiPdv(br: number, naziv: string) {
    let flag = 0;
    for (let i = 0; i < this.grupaProizvoda.length; i++) {
      if (this.grupaProizvoda[i].pdv === naziv) {
        alert('PDV povezan za grupu ne moze biti obrisan!');
        flag = 1;
        break;
      }
    }
    if (flag === 0) {
      this.pdvService.deletePdv(br)
        .subscribe(response => {
          alert('Uspesno ste obrisali!');
          window.location.reload();
        },
          err => {
            alert('Niste uspeli obrisati!');
          });
    }
  }
  izmeniPdv(pdvObj: PDV, naziv: string, izmeniPdvPolje: string) {
    if ( izmeniPdvPolje === '') {
      alert('Morate popuniti polje!');
      return;
    }
    for (let i = 0; i < this.pdv.length; i++) {
      if (izmeniPdvPolje === this.pdv[i].naziv) {
        alert('Vec postoji!');
        return;
      }
    }
    let flag = 0;
    for (let i = 0; i < this.grupaProizvoda.length; i++) {
      if (this.grupaProizvoda[i].pdv === naziv) {
        alert('PDV povezan za grupu ne moze biti izmenjen!');
        flag = 1;
        break;
      }
    }
    if (flag === 0) {
      this.pdvIzmenjen = pdvObj;
      this.pdvIzmenjen.naziv = izmeniPdvPolje;
      this.pdvIzmenjen.stopaPDVList = null;
      this.pdvService.updatePdv(this.pdvIzmenjen)
        .subscribe(response => {
            alert('Uspesno ste izmenili!');
            window.location.reload();
          },
          err => {
            alert('Niste uspeli izmenili!');
          });
    }
  }
  prikaziModal() {

  }
  stopaPdv() {
    this.router.navigateByUrl('stopa-pdv');
  }
}
