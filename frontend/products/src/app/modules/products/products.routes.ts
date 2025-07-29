import {Routes} from '@angular/router';
import {List} from './list/list';
import {Products} from './products';

export const routes: Routes = [{ path: '', component: Products, children: [
  { path: '', loadComponent: () => import('./list/list').then((c) => c.List),
    pathMatch: 'full' },
  ]}];
