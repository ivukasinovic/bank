import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {LoginComponent} from './login/login.component';
import {RouterModule, Routes} from '@angular/router';
import {RegisterComponent} from './register/register.component';
import {HomePageComponent} from './home-page/home-page.component';
import {PocetnaComponent} from './pocetna/pocetna.component';
import {GenerisiNalogComponent} from './generisi-nalog/generisi-nalog.component';
import {PrijedlogPlacanjaComponent} from './prijedlog-placanja/prijedlog-placanja.component';

const routes: Routes = [
  { path: '', redirectTo: '/pocetna', pathMatch: 'full' },
  {path: 'home-page', component: HomePageComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'pocetna', component: PocetnaComponent},
  {path: 'generisi-nalog', component: GenerisiNalogComponent},
  {path: 'prijedlog-placanja', component: PrijedlogPlacanjaComponent}
];

@NgModule({
  exports: [RouterModule],
  imports: [RouterModule.forRoot(routes)]
})
export class AppRoutingModule { }
