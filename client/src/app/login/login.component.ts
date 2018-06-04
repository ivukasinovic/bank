import { Component, OnInit } from '@angular/core';
import {KorisnikServiceService} from '../korisnik-service.service';
import {User} from '../model/korisnik';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  korisnik: User;

  constructor(private korisnikService: KorisnikServiceService) {
    this.korisnik = JSON.parse(localStorage.getItem('ulogovaniKorisnik'));
  }

  ngOnInit() {
  }

  login(email: string, lozinka: string) {
    this.korisnikService.loginUser(email, lozinka);
  }

}
