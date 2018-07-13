import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Proizvod} from '../model/model';

@Injectable()
export class ProizvodService {

  constructor(private http: HttpClient) { }

  getProizvodi() {
    return this.http.get('api/proizvod');
  }

  postProizvod(proizvod: Proizvod, idGrupe: number, idJedinice: number) {
    return this.http.post('api/proizvod/' + idGrupe + '/' + idJedinice, proizvod);
  }

  deletePrroizvod(id: number) {
    return this.http.delete('api/proizvod/' + id);
  }
  getGrupe() {
    return this.http.get('api/grupaProizvoda');
  }

}
