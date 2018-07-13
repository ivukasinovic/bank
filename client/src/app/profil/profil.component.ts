import { Component, OnInit } from '@angular/core';
import {Adresa, Preduzece} from '../model/model';
import {FakturaService} from '../service/faktura.service';

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.css']
})
export class ProfilComponent implements OnInit {

  preduzece: Preduzece;
  preduzece22: Preduzece;

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
  }

}
