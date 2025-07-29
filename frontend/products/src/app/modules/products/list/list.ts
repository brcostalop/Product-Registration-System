import {Component, signal} from '@angular/core';
import {Product} from '../product.model';
import {Service} from '../../service/service';
import {HttpClient, HttpClientModule} from '@angular/common/http';

@Component({
  selector: 'app-list',
  imports: [HttpClientModule],
  templateUrl: './list.html',
  styleUrl: './list.scss'
})
export class List {

  protected readonly title = signal('products');
  produtos: Product[] = [];
  message = signal<string>('');

  constructor(private http: HttpClient) {
    this.loadProducts();
  }

  loadProducts() {
    this.http.get<Product[]>('http://localhost:8080/api/products/list').subscribe({
      next: (data) => {
        this.produtos = data;
        console.log(data);
      },
      error: (err) => {
        console.log(err);
      }
    })
  }

}
