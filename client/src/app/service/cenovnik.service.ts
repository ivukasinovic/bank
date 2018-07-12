import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Cenovnik} from '../model/model';

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

  postCenovnik (cenovnik: Cenovnik) {
    return this.http.post( 'api/cenovnik', cenovnik);
  }

}
