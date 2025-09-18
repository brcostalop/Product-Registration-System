import {Injectable, signal} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Product} from '../products/product.model';
import {environment} from '../../environment/environment';

@Injectable({
  providedIn: 'root',
})
export class Service {
  protected readonly BASE_URL = signal(environment.apiUrl);

  constructor(private http: HttpClient) {}

  getList(): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.BASE_URL()}`);
  }

  save(product: Product): Observable<Product> {
    return this.http.post<Product>(`${this.BASE_URL()}/save`, product);
  }

  searchById(id: number): Observable<Product> {
    return this.http.get<Product>(`${this.BASE_URL()}/${id}`);
  }

  delete(id: number): Observable<Product> {
    return this.http.delete<Product>(`${this.BASE_URL()}/${id}`);
  }

  edit(id: number, product: Product): Observable<Product> {
    return this.http.put<Product>(`${this.BASE_URL()}/${id}`, product);
  }

  getPage(page: number, size: number, sort: string): Observable<Page<Product>> {
    return this.http.get<Page<Product>>(`${this.BASE_URL()}/page?page=${page}&size=${size}&sortBy=${sort}`);
  }

  searchFilters(filters: { [key: string]: string }): Observable<Product[]> {
    let params = new HttpParams();
    for (const key in filters) {
      if (filters[key]) {
        params = params.set(key, filters[key]);
      }
    }
    return this.http.get<Product[]>(`${this.BASE_URL()}/search`, {params});
  }

}
