import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { Heder1Component } from './heder1/heder1.component';
import { HeaderComponent } from './header/header.component';
import { AppRoutingModule } from './app-routing.module';
import {RouterModule} from '@angular/router';
import { RegisterComponent } from './register/register.component';
import {HttpClientModule} from '@angular/common/http';
import {KorisnikServiceService} from './service/korisnik-service.service';
import { HomePageComponent } from './home-page/home-page.component';
import { NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { PocetnaComponent } from './pocetna/pocetna.component';
import { GenerisiNalogComponent } from './generisi-nalog/generisi-nalog.component';
import {FakturaService} from './service/faktura.service';
import {FormsModule} from '@angular/forms';
import { PrijedlogPlacanjaComponent } from './prijedlog-placanja/prijedlog-placanja.component';
import { ProfilComponent } from './profil/profil.component';
import { MojeFaktureComponent } from './moje-fakture/moje-fakture.component';
import { PartneriComponent } from './partneri/partneri.component';
import { PdvComponent } from './pdv/pdv.component';
import {PdvService} from './service/pdv.service';
import { StopaPdvComponent } from './stopa-pdv/stopa-pdv.component';
import {StopaPdvService} from './service/stopa-pdv.service';
import { StavkeFaktureComponent } from './stavke-fakture/stavke-fakture.component';
import { CenovniciComponent } from './cenovnici/cenovnici.component';
import { StavkeCenovnikaComponent } from './stavke-cenovnika/stavke-cenovnika.component';
import {CenovnikService} from './service/cenovnik.service';
import { NoviCenovnikComponent } from './cenovnici/novi-cenovnik/novi-cenovnik.component';
import {ModalModule} from 'ngx-bootstrap';
import { DodajPdvComponent } from './pdv/dodaj-pdv/dodaj-pdv.component';
import { NalogComponent } from './nalog/nalog.component';
import { JedinicaMereComponent } from './jedinica-mere/jedinica-mere.component';
import { ValuteComponent } from './valute/valute.component';
import {SifrarniciService} from './service/sifrarnici.service';
import { GrupaProizvodaComponent } from './grupa-proizvoda/grupa-proizvoda.component';
import {GrupaProizvodaService} from './service/grupa-proizvoda.service';
import { ProizvodiComponent } from './proizvodi/proizvodi.component';
import { NoviProizvodComponent } from './proizvodi/novi-proizvod/novi-proizvod.component';
import {ProizvodService} from './service/proizvod.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    Heder1Component,
    HeaderComponent,
    RegisterComponent,
    HomePageComponent,
    PocetnaComponent,
    GenerisiNalogComponent,
    PrijedlogPlacanjaComponent,
    ProfilComponent,
    MojeFaktureComponent,
    PartneriComponent,
    PdvComponent,
    StopaPdvComponent,
    StavkeFaktureComponent,
    CenovniciComponent,
    StavkeCenovnikaComponent,
    NoviCenovnikComponent,
    NalogComponent,
    JedinicaMereComponent,
    ValuteComponent,
    DodajPdvComponent,
    NalogComponent,
    GrupaProizvodaComponent,
    ProizvodiComponent,
    NoviProizvodComponent
  ],
  imports: [
    BrowserModule,
    NgbModule.forRoot(),
    AppRoutingModule,
    RouterModule,
    HttpClientModule,
    FormsModule,
    ModalModule.forRoot()
  ],
  providers: [KorisnikServiceService,
    FakturaService,
    PdvService,
    StopaPdvService,
    CenovnikService,
    SifrarniciService,
    GrupaProizvodaFront-CRUD,
    ProizvodService,
    GrupaProizvodaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
