import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Cenovnik, StavkaCenovnika} from '../model/model';


@Injectable()
export class CenovnikService {

  constructor(private http: HttpClient) { }

  get() {
    return this.http.get('api/cenovnik');
  }

  getValute() {
    return this.http.get('api/valuta');
  }
  getProizvodi() {
    return this.http.get('api/proizvod');
  }

  obrisi( id: number) {
    return this.http.delete('api/cenovnik/' + id);
  }
 obrisiStavku( id: number) {
    return this.http.delete('api/stavkaCenovnika/' + id);
  }

  postCenovnik (cenovnik: Cenovnik, idValute: number) {
    return this.http.post( 'api/cenovnik/' + idValute, cenovnik);
  }

  postStavku (stavka: StavkaCenovnika, idCenovnika: number, idProizvoda) {
    return this.http.post( 'api/stavkaCenovnika/' + idCenovnika + '/' + idProizvoda, stavka);
  }

}
