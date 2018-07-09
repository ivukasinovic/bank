import { Component, OnInit } from '@angular/core';
import {Partnerstvo, Preduzece} from '../model/model';
import {FakturaService} from "../service/faktura.service";

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.css']
})
export class ProfilComponent implements OnInit {

  preduzece: Preduzece;

  constructor(private  fakturaService: FakturaService) { }

  ngOnInit() {
   // this.preduzece = JSON.parse(localStorage.getItem('trenutnoPreduzece'));

    this.fakturaService.getPartnerstvo(this.preduzece.id).subscribe(
      (response: Preduzece) => {
        this.preduzece = response;
      }
    );
  }

}
