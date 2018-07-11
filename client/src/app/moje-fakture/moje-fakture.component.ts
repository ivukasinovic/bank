import { Component, OnInit } from '@angular/core';
import {Faktura} from '../model/model';
import {FakturaService} from '../service/faktura.service';

@Component({
  selector: 'app-moje-fakture',
  templateUrl: './moje-fakture.component.html',
  styleUrls: ['./moje-fakture.component.css']
})
export class MojeFaktureComponent implements OnInit {

  faktura: Faktura[];
  izlazneFakture: Faktura[];

  constructor(private fakturaService: FakturaService) {

    this.fakturaService.getUlazneFakture().subscribe(
      (response: Faktura []) => {
        this.faktura = response;
      }
    );


    this.fakturaService.getIzlaneFakture().subscribe(
      (response: Faktura []) => {
        this.izlazneFakture = response;
      }
    );

  }

  ngOnInit() {
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
