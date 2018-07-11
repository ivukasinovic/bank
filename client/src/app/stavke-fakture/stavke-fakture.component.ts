import { Component, OnInit } from '@angular/core';
import {StavkaFakture} from '../model/model';

@Component({
  selector: 'app-stavke-fakture',
  templateUrl: './stavke-fakture.component.html',
  styleUrls: ['./stavke-fakture.component.css']
})
export class StavkeFaktureComponent implements OnInit {

  stavke: StavkaFakture[];

  constructor() { }

  ngOnInit() {
    this.stavke = JSON.parse(localStorage.getItem('stavke'));
  }

}
