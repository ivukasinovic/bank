import { Component, OnInit } from '@angular/core';
import {KorisnikServiceService} from '../korisnik-service.service';
import {Router} from '@angular/router';
import {Preduzece, User} from '../model/korisnik';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  private korisnik: User;
  private preduzece: Preduzece;

  constructor(private korisnikService: KorisnikServiceService, private router: Router) {
  //  this.korisnik = new User();
    this.preduzece = new Preduzece();
  }

  ngOnInit() {
  }
  register( naziv: string , email: string, lozinka1: string, lozinka2: string, pib: string,
            adresa: string) {
    if ( naziv === '' || email === '' || lozinka1 === '' || lozinka2 === '' || pib === '' ||
      adresa === '' ) {
      alert('Morate popuniti sva polja!');
      return;
    }

    if (this.provjeriLozinke(lozinka1, lozinka2) === false) {
      return;
    }

    this.preduzece.email = email;
    this.preduzece.naziv = naziv;
    this.preduzece.pib = pib;
    this.preduzece.lozinka = lozinka1;
    this.preduzece.adress = adresa;

  //  this.korisnik.activated = false;
      // this.korisnik.role = 'USER';
    this.korisnikService.registerNewUser(this.preduzece);  // this.korisnik);
    this.router.navigateByUrl('/pocetna');       // /home-page');
  }

  provjeriLozinke(lozinka1: string, lozinka2: string) {
    if (lozinka1 !== lozinka2) {
      alert('Lozinke se ne poklapaju!');
      return false;
    }

    return true;
  }
}
