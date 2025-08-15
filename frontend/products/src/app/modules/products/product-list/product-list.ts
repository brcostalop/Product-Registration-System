import {Component, OnInit, signal} from '@angular/core';
import {Product} from '../product.model';
import {HttpClient} from '@angular/common/http';
import {Service} from '../../service/service';
import {Router} from '@angular/router';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-product-list',
  imports: [
    FormsModule
  ],
  templateUrl: './product-list.html',
  styleUrl: './product-list.scss'
})
export class ProductList implements OnInit{
  products: Product[] = [];
  filters: { [key: string]: string } = {};

  constructor(private http: HttpClient, private service: Service,
              private router: Router) {}

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

  new() {
    this.router.navigate(['/produtos/novo']);
  }

  edit(id: number) {
    this.router.navigate(['/produtos/editar', id]);
  }

  search(): void {
    this.service.searchFilters(this.filters).subscribe({
      next: (data) => (
        this.products = data
      )
    })

  }

}
