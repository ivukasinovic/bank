import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {JedinicaMere, Valuta} from '../model/model';

@Injectable()
export class SifrarniciService {

  constructor(private http: HttpClient) { }


    getValute() {
      return this.http.get('api/valuta');
    }

    postValutu(valuta: Valuta) {
      return this.http.post('api/valuta', valuta);
    }

    deleteValute(id: number) {
      return this.http.delete('api/valuta/' + id);
    }

    getJediniceMere() {
      return this.http.get('api/jedinicaMere');
    }

  postJedinicuMere(jm: JedinicaMere) {
    return this.http.post('api/jedinicaMere', jm);
  }
    deleteJediniceMere(id: number) {
      return this.http.delete('api/jedinicaMere/' + id);
    }

}
