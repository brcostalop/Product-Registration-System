import {Component, OnInit, ViewChild} from '@angular/core';
import {Product} from '../product.model';
import {HttpClient} from '@angular/common/http';
import {Service} from '../../service/service';
import {Router} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {MatTableModule} from '@angular/material/table';
import {MatButtonModule} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatCardModule} from '@angular/material/card';
import {MatPaginator, PageEvent} from '@angular/material/paginator';

@Component({
  selector: 'app-product-list',
  imports: [
    FormsModule,
    MatTableModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatPaginator,
  ],
  templateUrl: './product-list.html',
  styleUrl: './product-list.scss'
})
export class ProductList implements OnInit{
  products: Product[] = [];
  filters: { [key: string]: string } = {};
  displayedColumns: string[] = ['name', 'category', 'price', 'description', 'actions'];
  totalElements: number = 0;

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private http: HttpClient, private service: Service,
              private router: Router) {}

  ngOnInit() {
    this.loadProducts(0, 10, 'name');
  }

  loadProducts(page: number, size: number, sort: string) {
    this.service.getPage(page, size, sort).subscribe({
      next: (data) => {
        this.products = data.content;
        this.totalElements = data.totalElements;
      },
      error: (err) => {
        console.log(err);
      }
    })
  }

  // loadProducts() {
  //   this.service.getList().subscribe({
  //     next: (data) => {
  //       this.products = data;
  //     },
  //     error: (err) => {
  //       console.log(err);
  //     }
  //   })
  // }

  page(event: PageEvent) {
    this.loadProducts(event.pageIndex, event.pageSize, 'name');
  }

  delete(id: number) {
    if (confirm('Deseja realmente excluir?')) {
      this.service.delete(id).subscribe({
        next: () => {
          this.loadProducts(0, 10, 'name');
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
