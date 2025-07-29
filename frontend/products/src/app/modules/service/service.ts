import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Product} from '../products/product.model';

@Injectable({
  providedIn: 'root',
})
export class Service {
  private apiUrl = 'http://localhost:8080/api/products';

  constructor(private http: HttpClient) {}

  getList(): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.apiUrl}/list`);
  }
}
