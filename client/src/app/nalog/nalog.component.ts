import { Component, OnInit } from '@angular/core';
import {FakturaService} from "../service/faktura.service";
import {Router} from "@angular/router";
import {NalogZaPlacanje} from "../model/model";

@Component({
  selector: 'app-nalog',
  templateUrl: './nalog.component.html',
  styleUrls: ['./nalog.component.css']
})
export class NalogComponent implements OnInit {

  nalozi: NalogZaPlacanje[];

  constructor(private fakturaService: FakturaService, private router: Router) { }

  ngOnInit() {

    this.fakturaService.getNalozi().subscribe(
      (response:  NalogZaPlacanje[]) => {
        this.nalozi = response;
      },
      error1 => {
        alert('Nije uspjelo dodavanje naloga!');
      }
    );

  }

}
