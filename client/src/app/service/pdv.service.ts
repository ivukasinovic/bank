import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {PDV} from '../model/model';

@Injectable()
export class PdvService {

  constructor(private http: HttpClient) { }

  getAllPdv() {
    return this.http.get( 'api/pdv/');
  }
  getPdvBezGrupe() {
    return this.http.get('api/pdv/bezGrupe');
  }

  deletePdv(id: number) {
    return this.http.delete('api/pdv/' + id);
  }
  getGrupaProizvoda() {
    return this.http.get( 'api/grupaProizvoda/');
  }
  updatePdv(pdv: PDV) {
    return this.http.post('api/pdv/' + pdv.id , null);
  }
}
