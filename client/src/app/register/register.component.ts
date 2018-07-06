import { Component, OnInit } from '@angular/core';
import {KorisnikServiceService} from '../korisnik-service.service';
import {Router} from '@angular/router';
import {Adresa, Preduzece, User} from '../model/korisnik';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  private korisnik: User;
  private preduzece: Preduzece;
 // private adresa: Adresa;
public selektovanaAdresa: Adresa;


  private postojeceAdrese: Adresa[];

  constructor(private korisnikService: KorisnikServiceService, private router: Router) {
  //  this.korisnik = new User();
    this.preduzece = new Preduzece();
    //this.adresa = new Adresa();

    this.korisnikService.allAdress().subscribe(
      (response: Adresa[]) => {
        this.postojeceAdrese = response;
      });
  }

  ngOnInit() {
  }

  employeeSelected(event) {
    console.log('selected employee: ' + event);
  }

  register( naziv: string , email: string, lozinka1: string, lozinka2: string, pib: string,
            adresa: number) {
  //  console.log(adresa);


    if ( naziv === '' || email === '' || lozinka1 === '' || lozinka2 === '' || pib === '') {
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
    // this.preduzece.adresa = adresa;

    // this.preduzece.adress.drzava = adresa.drzava;
    // this.preduzece.adress.broj = adresa.broj;
    // this.preduzece.adress.grad = adresa.grad;
    // this.preduzece.adress.ulica = adresa.ulica;

  //  this.korisnik.activated = false;

    console.log(this.preduzece);
    this.korisnikService.registerNewUser(adresa, this.preduzece);  // this.korisnik);
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
