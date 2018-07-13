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
    localStorage.setItem('stavke', JSON.stringify(stavke));
    this.router.navigateByUrl('/stavke-cenovnika');
  }

  update(cenovnik: Cenovnik) {
    localStorage.setItem('cenUpdate', JSON.stringify(cenovnik));
    this.router.navigateByUrl('/cenovnik');
  }

  obrisi(id: number) {
    this.cenovnikService.obrisi(id).subscribe(
      (response: any ) => {
          this.cenovnici.forEach( function (value, index, array) {
            if (value.id === id) {
              array.splice(index, 1);
            }
          });
      },
      error1 => {
        alert('Nije uspjelo brisanje cenovnika!');
      }
    );
  }


}
