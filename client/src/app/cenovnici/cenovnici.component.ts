import { Component, OnInit } from '@angular/core';
import {Cenovnik, Faktura, StavkaCenovnika, StavkaFakture} from '../model/model';
import {Router} from '@angular/router';
import {CenovnikService} from '../service/cenovnik.service';

@Component({
  selector: 'app-cenovnici',
  templateUrl: './cenovnici.component.html',
  styleUrls: ['./cenovnici.component.css']
})
export class CenovniciComponent implements OnInit {

  cenovnici: Cenovnik[];

  constructor(private router: Router, private cenovnikService: CenovnikService) { }

  ngOnInit() {
    this.cenovnikService.get().subscribe(
      (response: Cenovnik []) => {
        this.cenovnici = response;
      },
      error1 => {
        alert('Nije uspjelo ucitavanje cenovnika!');
      }
    );
  }

  setStavke(stavke: StavkaCenovnika[]) {
    console.log('stavke su ' + stavke);
    localStorage.setItem('stavke', JSON.stringify(stavke));
    this.router.navigateByUrl('/stavke-cenovnika');
  }

}
