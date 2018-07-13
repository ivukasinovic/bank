import { Component, OnInit } from '@angular/core';
import {GrupaProizvoda, JedinicaMere, Proizvod} from '../../model/model';
import {ProizvodService} from '../../service/proizvod.service';
import {SifrarniciService} from '../../service/sifrarnici.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-novi-proizvod',
  templateUrl: './novi-proizvod.component.html',
  styleUrls: ['./novi-proizvod.component.css']
})
export class NoviProizvodComponent implements OnInit {

  proizvod: Proizvod = new Proizvod();
  jediniceList: JedinicaMere[] = [];
  jedinicaId: number;
  grupe: GrupaProizvoda[];
  grupaId: number;
  update = false;

  constructor(private proizvodService: ProizvodService, private sifrarnikService: SifrarniciService, private router: Router) { }

  ngOnInit() {
    this.proizvodService.getGrupe().subscribe(
      (response: GrupaProizvoda[]) => {
        this.grupe = response;
        this.sifrarnikService.getJediniceMere().subscribe(
          (response2: JedinicaMere[]) => {
            this.jediniceList = response2;

            if (localStorage.getItem('proizvodUpd') != null) {
              this.update = true;
              this.proizvod = JSON.parse(localStorage.getItem('proizvodUpd'));
              localStorage.removeItem('proizvodUpd');

              let idTemp, nazivTemp;
              nazivTemp = this.proizvod.grupaProizvoda;
              this.grupe.forEach( function (value, index, array) {
                if (value.naziv == nazivTemp) {
                  idTemp = value.id;
                }
              });

              this.grupaId = idTemp;

               nazivTemp = this.proizvod.jedinicaMere;
              this.jediniceList.forEach( function (value, index, array) {
                if (value.skracenica == nazivTemp) {
                  idTemp = value.id;
                }
              });

              this.jedinicaId = idTemp;


              this.proizvod.jedinicaMere = null;
              this.proizvod.grupaProizvoda = null;
              this.proizvod.preduzece = null;
            }
          },
          error2 => {
            alert('Nisu ucitane jedinice mere!');
          }
        );

      },
      error2 => {
        alert('Nisu ucitane grupe!');
      }
    );

  }
  dodaj() {
      this.proizvodService.postProizvod(this.proizvod, this.grupaId, this.jedinicaId).subscribe(
        (response: any) => {
          alert('Uspijeh!');
          this.router.navigateByUrl('proizvodi');
    }, error2 => {
          alert('Greska');
        }
      );
  }
}
