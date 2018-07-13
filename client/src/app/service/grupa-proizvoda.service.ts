import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {GrupaProizvoda, PDV, StopaPDV} from '../model/model';

@Injectable()
export class GrupaProizvodaService {

  constructor(private http: HttpClient) { }
  getGrupeProizvoda() {
    return this.http.get( 'api/grupaProizvoda');
  }

  deleteGrupa(id: number) {
    return this.http.delete('api/grupaProizvoda/' + id);
  }

  updateGrupaProizvodaWithPDVId(grupa: GrupaProizvoda, pdvId: number ) {
    return this.http.post('api/grupaProizvoda/izmena/' + pdvId, grupa);
  }

  postGrupaProizvoda(grupa: GrupaProizvoda, pdvId: number ) {
    return this.http.post('api/grupaProizvoda/dodajSaID/' + pdvId, grupa);
  }
}
