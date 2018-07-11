import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {LoginComponent} from './login/login.component';
import {RouterModule, Routes} from '@angular/router';
import {RegisterComponent} from './register/register.component';
import {HomePageComponent} from './home-page/home-page.component';
import {PocetnaComponent} from './pocetna/pocetna.component';
import {GenerisiNalogComponent} from './generisi-nalog/generisi-nalog.component';
import {PrijedlogPlacanjaComponent} from './prijedlog-placanja/prijedlog-placanja.component';
import {ProfilComponent} from './profil/profil.component';
import {MojeFaktureComponent} from './moje-fakture/moje-fakture.component';
import {PartneriComponent} from './partneri/partneri.component';
import {StavkeFaktureComponent} from './stavke-fakture/stavke-fakture.component';
import {CenovniciComponent} from './cenovnici/cenovnici.component';
import {StavkaCenovnika} from './model/model';
import {StavkeCenovnikaComponent} from './stavke-cenovnika/stavke-cenovnika.component';

const routes: Routes = [
  { path: '', redirectTo: '/pocetna', pathMatch: 'full' },
  {path: 'home-page', component: HomePageComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'pocetna', component: PocetnaComponent},
  {path: 'generisi-nalog', component: GenerisiNalogComponent},
  {path: 'profil', component: ProfilComponent},
  {path: 'moje-fakture', component: MojeFaktureComponent},
  {path: 'partneri', component: PartneriComponent},
  {path: 'prijedlog-placanja', component: PrijedlogPlacanjaComponent},
  {path: 'stavke-fakture', component: StavkeFaktureComponent},
  {path: 'cenovnici', component: CenovniciComponent},
  {path: 'stavke-cenovnika', component: StavkeCenovnikaComponent}
];

@NgModule({
  exports: [RouterModule],
  imports: [RouterModule.forRoot(routes)]
})
export class AppRoutingModule { }
