import {Routes} from '@angular/router';
import {Products} from './products';

export const routes: Routes = [
  {
    path: '', component: Products, children: [
    {
      path: '', loadComponent: () => import('./product-list/product-list')
        .then((c) => c.ProductList), pathMatch: 'full'
    },]
  }];
