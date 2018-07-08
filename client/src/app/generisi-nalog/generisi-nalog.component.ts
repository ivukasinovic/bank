import { Component, OnInit } from '@angular/core';
import {Faktura, StaSePlaca} from '../model/model';
import {FakturaService} from '../service/faktura.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-generisi-nalog',
  templateUrl: './generisi-nalog.component.html',
  styleUrls: ['./generisi-nalog.component.css']
})
export class GenerisiNalogComponent implements OnInit {

  neplacene: Faktura[];
  iznos: number[] = [];
  isCh: boolean[] = [];
  prijedlogPlacanja: StaSePlaca[] = [];

  constructor(private fakturaService: FakturaService, private router: Router) { }

  ngOnInit() {
    this.fakturaService.getNeplacene().subscribe((result: Faktura[]) => {
        this.neplacene = result;
        let i: number;
        for (i = 0; i < this.neplacene.length; i++ ) {
          this.iznos[i] = this.neplacene[i].preostaliIznos;
          this.isCh[i] = false;
          console.log('iznos je ' + this.iznos[i]);
        }
        console.log('done');
      },
      error1 => {
        alert('Doslo je do greske');
      });
  }

  generisiPrijedlog() {
    let i: number;
    for (i = 0; i < this.neplacene.length; i++ ) {
      if (this.isCh[i] === true) {
        const temp: StaSePlaca = new StaSePlaca();
        temp.faktura = this.neplacene[i];
        temp.iznos = this.iznos[i];
        console.log('iznos ' , this.iznos[i], ' faktura', this.neplacene[i]);
        this.prijedlogPlacanja.push(temp);
      }
    }
    localStorage.removeItem('prijedlogplacanja');
    localStorage.setItem('prijedlogplacanja', JSON.stringify( this.prijedlogPlacanja));
    this.router.navigateByUrl('prijedlog-placanja');
  }
}
