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
  private preduzece: Preduzece;

  constructor(private  fakturaService: FakturaService) { }

  ngOnInit() {
    this.preduzece = JSON.parse(localStorage.getItem('trenutnoPreduzece'));
    this.fakturaService.getPartnerstvo(this.preduzece.id).subscribe(
      (response: Partnerstvo []) => {
        this.partnerstvo = response;
      }
    );
  }


}
