import { Component, OnInit } from '@angular/core';
import {Faktura, StaSePlaca} from '../model/model';
import {FakturaService} from '../service/faktura.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-prijedlog-placanja',
  templateUrl: './prijedlog-placanja.component.html',
  styleUrls: ['./prijedlog-placanja.component.css']
})
export class PrijedlogPlacanjaComponent implements OnInit {

  prijedlog: StaSePlaca[];
  constructor( private  fakturaService: FakturaService, private router: Router) { }

  ngOnInit() {
    this.prijedlog = JSON.parse(localStorage.getItem('prijedlogplacanja'));
  }

  generisiNaloge() {
    let i: number;
    for (i = 0; i < this.prijedlog.length; i++ ) {
     this.fakturaService.generisiNalog(this.prijedlog[i].faktura.id, this.prijedlog[i].iznos).subscribe(
       (result: any) => {

        if (i === this.prijedlog.length ) {
          alert('Uspiješno ste generisali naloge!');
          this.router.navigateByUrl('/home-page');
        }
      },
      error1 => {
        alert('Došlo je do greške!');
        return;
      });
    }


  }
}
