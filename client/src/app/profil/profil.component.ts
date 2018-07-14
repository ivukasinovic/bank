import { Component, OnInit } from '@angular/core';
import {DnevnoStanje, Partnerstvo, Preduzece} from '../model/model';
import {Adresa} from '../model/model';
import {FakturaService} from '../service/faktura.service';

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.css']
})
export class ProfilComponent implements OnInit {

  preduzece: Preduzece;
  preduzece22: Preduzece;

  dnevnoStanje: DnevnoStanje;

  constructor(private  fakturaService: FakturaService) {
    this.preduzece = new Preduzece();
    this.preduzece.adresa = new Adresa();
  }

  ngOnInit() {
   this.preduzece22 = JSON.parse(localStorage.getItem('trenutnoPreduzece'));

    this.fakturaService.getPreduzece(this.preduzece22.id).subscribe(
      (response: Preduzece) => {
        this.preduzece = response;
      }
    );

    this.fakturaService.getDnevnoStanje(this.preduzece22.id).subscribe(
      (response: DnevnoStanje) => {
        this.dnevnoStanje = response;
      }
    );
  }




}
