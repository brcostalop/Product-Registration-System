import {Component, OnInit, signal} from '@angular/core';
import {Product} from '../product.model';
import {HttpClient} from '@angular/common/http';
import {Service} from '../../service/service';

@Component({
  selector: 'app-product-list',
  imports: [],
  templateUrl: './product-list.html',
  styleUrl: './product-list.scss'
})
export class ProductList implements OnInit{
  products: Product[] = [];

  constructor(private http: HttpClient, private service: Service) {}

  ngOnInit() {
    this.loadProducts();
  }

  loadProducts() {
    this.service.getList().subscribe({
      next: (data) => {
        this.products = data;
      },
      error: (err) => {
        console.log(err);
      }
    })
  }

  delete(id: number) {
    if (confirm('Deseja realmente excluir?')) {
      this.service.delete(id).subscribe({
        next: (data) => {
          this.loadProducts();
        },
        error: (err) => {}
      })
    }
  }

}
