import { Component, OnInit } from '@angular/core';
import {User} from '../model/korisnik';
import {KorisnikServiceService} from '../korisnik-service.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-heder1',
  templateUrl: './heder1.component.html',
  styleUrls: ['./heder1.component.css']
})
export class Heder1Component implements OnInit {

  korisnik: User;
  tip: boolean;
  sisTip: boolean;
  regTip: boolean;



  constructor(private korisnikService: KorisnikServiceService, private router: Router) {
    this.korisnik = JSON.parse(localStorage.getItem('ulogovaniKorisnik'));
  }


  ngOnInit() {

  }

  logOut() {
    this.korisnikService.logOut();
    this.router.navigateByUrl('/');
  }

}
