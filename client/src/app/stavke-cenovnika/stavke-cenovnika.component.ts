import { Component, OnInit } from '@angular/core';
import {StavkaCenovnika} from '../model/model';

@Component({
  selector: 'app-stavke-cenovnika',
  templateUrl: './stavke-cenovnika.component.html',
  styleUrls: ['./stavke-cenovnika.component.css']
})
export class StavkeCenovnikaComponent implements OnInit {

  stavkeList: StavkaCenovnika[];

  constructor() { }

  ngOnInit() {
    this.stavkeList = JSON.parse(localStorage.getItem('stavke'));
  }

}
