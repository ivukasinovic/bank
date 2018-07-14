import { Component, OnInit } from '@angular/core';
import {FakturaService} from '../service/faktura.service';
import {Router} from '@angular/router';
import {NalogZaPlacanje, Preduzece} from '../model/model';
import {PdvService} from '../service/pdv.service';

@Component({
  selector: 'app-nalog',
  templateUrl: './nalog.component.html',
  styleUrls: ['./nalog.component.css']
})
export class NalogComponent implements OnInit {

  nalozi: NalogZaPlacanje[];
  preduzece: Preduzece;
  preduzece22: Preduzece;
  constructor(private pdvService: PdvService, private fakturaService: FakturaService, private router: Router) {
    this.preduzece = new Preduzece();
  }

  ngOnInit() {
    this.preduzece22 = JSON.parse(localStorage.getItem('trenutnoPreduzece'));

    this.fakturaService.getPreduzece(this.preduzece22.id).subscribe(
      (response: Preduzece) => {
        this.preduzece = response;
      }
    );
    this.fakturaService.getNalozi().subscribe(
      (response:  NalogZaPlacanje[]) => {
        this.nalozi = response;
      },
      error1 => {
        alert('Nije uspjelo dodavanje naloga!');
      }
    );

  }
  export() {
    alert('Preduuzece :' + this.preduzece.naziv);
    this.pdvService.exportNaloga(this.preduzece.id)
      .subscribe(() => {
          alert('Uspesno ste eksportovali!');
          window.location.reload();
        },
        err => {
          alert('Niste uspeli da eksportujete!');
        });
  }
}
