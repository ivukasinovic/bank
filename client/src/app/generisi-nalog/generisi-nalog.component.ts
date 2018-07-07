import { Component, OnInit } from '@angular/core';
import {Faktura} from '../model/model';
import {FakturaService} from '../service/faktura.service';

@Component({
  selector: 'app-generisi-nalog',
  templateUrl: './generisi-nalog.component.html',
  styleUrls: ['./generisi-nalog.component.css']
})
export class GenerisiNalogComponent implements OnInit {

  neplacene: Faktura[];

  constructor(private fakturaService: FakturaService) { }

  ngOnInit() {
    this.fakturaService.getNeplacene().subscribe((result: Faktura[]) => {
        this.neplacene = result;
        console.log('done');
      },
      error1 => {
        alert('Doslo je do greske');
      });
  }

}
