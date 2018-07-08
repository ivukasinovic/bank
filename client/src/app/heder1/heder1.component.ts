import { Component, OnInit } from '@angular/core';
import {Preduzece, User} from '../model/model';
import {KorisnikServiceService} from '../service/korisnik-service.service';
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
  preduzece: Preduzece;


  constructor(private korisnikService: KorisnikServiceService, private router: Router) {
    // this.korisnik = JSON.parse(localStorage.getItem('ulogovaniKorisnik'));
    this.preduzece = JSON.parse(localStorage.getItem('trenutnoPreduzece'));

  }


  ngOnInit() {

  }

  logOut() {
    this.korisnikService.logOut();
    this.router.navigateByUrl('/');
  }

}
