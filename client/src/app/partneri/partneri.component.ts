import { Component, OnInit } from '@angular/core';
import {FakturaService} from '../service/faktura.service';
import {Adresa, Partnerstvo, Preduzece} from '../model/model';

@Component({
  selector: 'app-partneri',
  templateUrl: './partneri.component.html',
  styleUrls: ['./partneri.component.css']
})
export class PartneriComponent implements OnInit {

  private partnerstvo: Partnerstvo [];
  sviPartneri: Preduzece[];

  private preduzece: Preduzece;

  private partner: Partnerstvo;

  constructor(private  fakturaService: FakturaService) {
    this.partner = new Partnerstvo();

  }

  ngOnInit() {

    this.preduzece = JSON.parse(localStorage.getItem('trenutnoPreduzece'));
    this.fakturaService.getPartnerstvo(this.preduzece.id).subscribe(
      (response: Partnerstvo []) => {
        this.partnerstvo = response;
      }
    );

    this.fakturaService.getSviPartnei(this.preduzece.id)
      .subscribe(
        (response: Preduzece[]) => {
          this.sviPartneri = response;
        });

  }

  obrisii(broj: number) {
    this.fakturaService.brisiPartnesrstvo(broj)
      .subscribe(response => {
          alert('Uspesno ste obrisali partnera!!!');
          window.location.reload();
        },
        err => {
          alert('Niste uspeli obrisati (Doslo je do greske)');
        }
    );
  }

  dodajPartnera(broj: Partnerstvo) {
    this.fakturaService.dodajPartnerstvoo(this.partner).subscribe(
      (data: Partnerstvo) => {

        alert('Uspesno te dodali partnera!');
        window.location.reload();
      },
      error1 => {
        alert('Error!');
      }
    );

  }

}
