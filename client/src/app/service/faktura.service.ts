import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Faktura} from '../model/model';

@Injectable()
export class FakturaService {

  constructor(private http: HttpClient) { }

  getNeplacene() {
    return this.http.get('api/faktura/neplacene');
  }

  generisiNalog( idFakture: number, iznos: number) {
    return this.http.get( 'api/nalog-za-placanje/generisi/' + idFakture + '/' + iznos);
  }
}