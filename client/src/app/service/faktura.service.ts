import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class FakturaService {

  constructor(private http: HttpClient) { }

  getNeplacene() {
    return this.http.get('api/faktura/neplacene');
  }
}
