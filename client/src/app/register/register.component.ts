import { Component, OnInit } from '@angular/core';
import {KorisnikServiceService} from '../korisnik-service.service';
import {Router} from '@angular/router';
import {User} from '../model/korisnik';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  private korisnik: User;

  constructor(private korisnikService: KorisnikServiceService, private router: Router) {
    this.korisnik = new User();
  }

  ngOnInit() {
  }
  register( username: string , email: string, lozinka1: string, lozinka2: string, ime: string,
            prezime: string, grad: string, broj: string) {
    if ( username === '' || email === '' || lozinka1 === '' || lozinka2 === '' || ime === '' ||
      prezime === '' || grad === '' || broj === '') {
      alert('Morate popuniti sva polja!');
      return;
    }

    if (this.provjeriLozinke(lozinka1, lozinka2) === false) {
      return;
    }

    this.korisnik.email = email;
    this.korisnik.city = grad;
    this.korisnik.name = ime;
    this.korisnik.surname = prezime;
    this.korisnik.password = lozinka1;
    this.korisnik.username = username;
    this.korisnik.number = broj;
    this.korisnik.activated = false;
      // this.korisnik.role = 'USER';
    this.korisnikService.registerNewUser(this.korisnik);
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
