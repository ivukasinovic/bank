import { Injectable } from '@angular/core';
import {Preduzece, User} from './model/korisnik';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';

@Injectable()
export class KorisnikServiceService {

  constructor(private http: HttpClient, private router: Router) { }

  registerNewUser(idAdrese: number, korisnik: Preduzece) {
    return this.http.post('api/user/register/' + idAdrese, korisnik).subscribe();
  }

  allAdress() {
    return this.http.get('api/adresa');
  }


  loginUser(email: string, lozinka: string) {
    return this.http.post('api/user/logIn', {email: email, lozinka: lozinka})
      .subscribe(res => {
         // localStorage.setItem('ulogovaniKorisnik', JSON.stringify(res));
          localStorage.setItem('trenutnoPreduzece', JSON.stringify(res));
          this.router.navigateByUrl('/home-page');   // home-page
        }
        ,
        err => {
          alert('Pogresan email ili lozinka!');
          console.log(err);
        }
        );
  }

  logOut() {
    this.http.get('api/user/logOut').subscribe();
    localStorage.removeItem('ulogovaniKorisnik');
  }


}
