import { Routes } from '@angular/router';

export const routes: Routes = [{ path: 'produtos', loadChildren: () =>
    import('./modules/products/products.routes').then((r) => r.routes)}];
