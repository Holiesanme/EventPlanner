import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';

export const APP1_ROUTES: Routes = [
    { path: '', component: HomeComponent, pathMatch: 'full'}
];
