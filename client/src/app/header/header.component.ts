import { Component, OnInit } from '@angular/core';
import {Preduzece, User} from '../model/korisnik';
import {KorisnikServiceService} from '../korisnik-service.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  korisnik: User;
  tip: boolean;
  sisTip: boolean;
  regTip: boolean;
  preduzece: Preduzece;


  constructor(private korisnikService: KorisnikServiceService, private router: Router) {
    // this.korisnik = JSON.parse(localStorage.getItem('ulogovaniKorisnik'));
    this.preduzece = JSON.parse(localStorage.getItem('trenutnoPreduzece'));
  }

  getMyAds() {
    this.router.navigate(['fanpage/my-ads']);
  }

  ngOnInit() {

    // if (this.korisnik.role === 'ADMIN') {
    //   this.sisTip = true;
    // } else {
    //   this.sisTip = false;
    // }
    //
    // if (this.korisnik.role === 'AGENT') {
    //   this.korisnik.activated = true;
    //   this.tip = true;
    // } else {
    //   this.korisnik.activated = false; // MADA MOGU I PREKO ID DA PROVERIM
    //   this.tip = false;
    // }
    //
    //
    // if (this.korisnik.role === 'User') {
    //   this.regTip = true;
    // } else {
    //   this.regTip = false;
    // }

  }

  logOut() {
    this.korisnikService.logOut();
    this.router.navigateByUrl('/');
  }

}
