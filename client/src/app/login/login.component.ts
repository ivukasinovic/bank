import { Component, OnInit } from '@angular/core';
import {KorisnikServiceService} from '../service/korisnik-service.service';
import {User} from '../model/model';

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
