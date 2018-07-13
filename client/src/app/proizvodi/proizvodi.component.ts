import { Component, OnInit } from '@angular/core';
import {Proizvod} from '../model/model';
import {ProizvodService} from '../service/proizvod.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-proizvodi',
  templateUrl: './proizvodi.component.html',
  styleUrls: ['./proizvodi.component.css']
})
export class ProizvodiComponent implements OnInit {

  proizvodiList: Proizvod[] = [];

  constructor(private proizvodService: ProizvodService, private router: Router) { }

  ngOnInit() {
    this.proizvodService.getProizvodi().subscribe(
      (result: Proizvod[]) => {
        this.proizvodiList = result;
      },
      error2 => {
        alert('Nije uspjelo učitavanje proizvoda');
      }
    );
  }

  obrisi(id: number) {
    this.proizvodService.deletePrroizvod(id).subscribe(
      (response: any) => {
        this.proizvodiList.forEach(function (value, index, array) {
          if (id === value.id) {
            array.splice(index, 1);
          }
        });
      },
      error2 => {
        alert('Nije uspjelo brisanje!');
      }
    );
  }

  update(proizvod: Proizvod) {
    localStorage.setItem('proizvodUpd', JSON.stringify(proizvod));
    this.router.navigateByUrl('/novi-proizvod');
  }
}
