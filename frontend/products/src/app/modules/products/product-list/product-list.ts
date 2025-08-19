import {Component, OnInit} from '@angular/core';
import {Product} from '../product.model';
import {HttpClient} from '@angular/common/http';
import {Service} from '../../service/service';
import {Router} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {MatTableModule} from '@angular/material/table';
import {MatButton} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';

@Component({
  selector: 'app-product-list',
  imports: [
    FormsModule,
    MatTableModule,
    MatButton,
    FormsModule,
    MatFormFieldModule,
    MatInputModule
  ],
  templateUrl: './product-list.html',
  styleUrl: './product-list.scss'
})
export class ProductList implements OnInit{
  products: Product[] = [];
  filters: { [key: string]: string } = {};
  displayedColumns: string[] = ['name', 'category', 'price', 'description', 'actions'];

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
        next: () => {
          this.loadProducts();
        },
        error: () => {}
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
