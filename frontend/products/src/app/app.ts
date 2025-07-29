import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {Product} from './modules/products/product.model';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {

}
