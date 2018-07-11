import { Component, OnInit } from '@angular/core';
import {Faktura, StavkaFakture} from '../model/model';
import {FakturaService} from '../service/faktura.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-moje-fakture',
  templateUrl: './moje-fakture.component.html',
  styleUrls: ['./moje-fakture.component.css']
})
export class MojeFaktureComponent implements OnInit {

  ulazne: Faktura[];
  izlazne: Faktura[];

  constructor(private fakturaService: FakturaService, private router: Router) {

    this.fakturaService.getUlazneFakture().subscribe(
      (response: Faktura []) => {
        this.ulazne = response;
        this.ulazne.forEach(function (value, index, array) {
          console.log(value.stavkaFaktureList);
        })
      },
      error1 => {
        alert('Nije uspjelo ucitavanje ulaznih faktura!');
      }
    );

    this.fakturaService.getIzlaneFakture().subscribe(
      (response: Faktura []) => {
        this.izlazne = response;
      }
    );



  }

  ngOnInit() {
  }

  setStavke(stavke: StavkaFakture[]) {
    console.log('stavke su ' + stavke);
    localStorage.setItem('stavke', JSON.stringify(stavke));
    this.router.navigateByUrl('/stavke-fakture');
  }

  // activate(br: number) {
  //   this.authService.activate(br)
  //     .subscribe(response => {
  //         alert('Uspesno ste aktivirali!!!');
  //         window.location.reload();
  //       },
  //       err => {
  //         alert('Niste uspeli (Doslo je do greske)');
  //       });
  // }
  //
  // block(br: number) {
  //   this.authService.block(br)
  //     .subscribe(response => {
  //         alert('Deaktivirali ste !!!');
  //         window.location.reload();
  //       },
  //       err => {
  //         alert('Niste uspeli obrisati (Doslo je do greske)');
  //       });
  // }
  //
  // obrisii(br: number) {
  //   this.authService.deleteUser(br)
  //     .subscribe(response => {
  //         alert('Uspesno ste obrisali korisnika!!!');
  //         window.location.reload();
  //       },
  //       err => {
  //         alert('Niste uspeli obrisati (Doslo je do greske)');
  //       });
  //
  // }

}
