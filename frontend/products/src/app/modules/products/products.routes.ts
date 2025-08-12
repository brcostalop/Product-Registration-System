import {Routes} from '@angular/router';
import {Products} from './products';

export const routes: Routes = [
  {
    path: '', component: Products, children: [
    {
      path: '', loadComponent: () => import('./product-list/product-list')
        .then((c) => c.ProductList), pathMatch: 'full'
    }, {
      path: 'novo', loadComponent: () => import('./product-form/product-form')
        .then((c) => c.ProductForm), pathMatch: 'full',
    }, {
      path: 'editar/:id', loadComponent: () => import('./product-form/product-form')
        .then((c) => c.ProductForm), pathMatch: 'full',
    }]
  }];
