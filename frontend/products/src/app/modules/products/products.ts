import {Component} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {Product} from './product.model';

@Component({
  selector: 'app-products',
  imports: [RouterOutlet],
  template: `<router-outlet></router-outlet>`,
  // styleUrl: './products.scss'
})
export class Products {

}
