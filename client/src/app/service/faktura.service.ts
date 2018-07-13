import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Faktura, Partnerstvo} from '../model/model';

@Injectable()
export class FakturaService {

  constructor(private http: HttpClient) { }

  getNeplacene() {
    return this.http.get('api/faktura/neplacene');
  }

  getNalozi() {
    return this.http.get('api/nalog-za-placanje');
  }

  generisiNalog( idFakture: number, iznos: number) {
    return this.http.get( 'api/nalog-za-placanje/generisi/' + idFakture + '/' + iznos);
  }

  getPartnerstvo(partnerstvo: number) {
    return this.http.get( 'api/partnerstvo/samo-nasi/' + partnerstvo);
  }

  getPreduzece(partnerstvo: number) {
    return this.http.get( 'api/preduzece/' + partnerstvo);
  }

  getIzlaneFakture() {
    return this.http.get('api/faktura/izlazne');
  }

  getUlazneFakture() {
    return this.http.get('api/faktura/ulazne');
  }
  getFakture() {
    return this.http.get('api/faktura');
  }

  storniraj(fakturaId: number) {
    return this.http.get('api/faktura/stornirana/' + fakturaId);
  }

 dodajPartnerstvoo (fakturaId: Partnerstvo) {
    return this.http.post('api/partnerstvo' , fakturaId);
  }

  brisiPartnesrstvo(fakturaId: number) {
    return this.http.delete('api/partnerstvo/' + fakturaId);
  }

  getSviPartnei(asd: number) {
    return this.http.get('api/partnerstvo/ostali/' + asd);
  }
}
