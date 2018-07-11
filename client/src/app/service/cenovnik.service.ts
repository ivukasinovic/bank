import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class CenovnikService {

  constructor(private http: HttpClient) { }

  get() {
    return this.http.get('api/cenovnik');
  }
}
