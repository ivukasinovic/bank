import { Component, OnInit } from '@angular/core';
import {Faktura, StavkaFakture, StavkaIzvoda} from '../model/model';
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
  stavkaIzvoda: StavkaIzvoda;

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

  activate(broj: number) {
    this.fakturaService.storniraj(broj).subscribe(
      response => {
                alert(' !!!');
                window.location.reload();
              },
              err => {
                alert('Niste uspeli stornirati');
              }
    );
  }
  getKUF() {
    this.fakturaService.getIzvestaj('kuf')
      .subscribe(() => {
          alert('Uspesno ste generisali izvestaj, sacuvan je na desktopu!')
      },
        error1 => {
          alert('Doslo je do greske, nije uspelo generisanje izvestaja!');
        });
  }
  getKIF() {
    this.fakturaService.getIzvestaj('kif')
      .subscribe(() => {
          alert('Uspesno ste generisali izvestaj, sacuvan je na desktopu!')
        },
        error1 => {
          alert('Doslo je do greske, nije uspelo generisanje izvestaja!');
        });
  }
  getKP() {
    this.fakturaService.getIzvestaj('kp')
      .subscribe(() => {
          alert('Uspesno ste generisali izvestaj, sacuvan je na desktopu!')
        },
        error1 => {
          alert('Doslo je do greske, nije uspelo generisanje izvestaja!');
        });
  }
  getIOS() {
    this.fakturaService.getIzvestaj('ios')
      .subscribe(() => {
          alert('Uspesno ste generisali izvestaj, sacuvan je na desktopu!')
        },
        error1 => {
          alert('Doslo je do greske, nije uspelo generisanje izvestaja!');
        });
  }

}
