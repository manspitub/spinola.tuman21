import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './modules/app-routing.module';
import { AppComponent } from './app.component';
import { MaterialImportsModule } from './modules/material-imports.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ViviendaListComponent } from './vivienda-list/vivienda-list.component';
import { ViviendaItemComponent } from './vivienda-item/vivienda-item.component';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './components/home/home.component';
import { SideMenuComponent } from './shared/side-menu/side-menu.component';
import { FormularioIComponent } from './components/formulario-i/formulario-i.component';
import { FormularioVComponent } from './components/formulario-v/formulario-v.component';
import { FormularioInteresadoComponent } from './components/formulario-interesado/formulario-interesado.component';
import { FooterComponent } from './shared/footer/footer.component';
import { ViviendaDetailsComponent } from './vivienda-details/vivienda-details.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';




@NgModule({
  declarations: [
    AppComponent,
    ViviendaListComponent,
    ViviendaItemComponent,
    HomeComponent,
    SideMenuComponent,
    FormularioIComponent,
    FormularioVComponent,
    FormularioInteresadoComponent,
    FooterComponent,
    ViviendaDetailsComponent,
    PageNotFoundComponent


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MaterialImportsModule,
    BrowserAnimationsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
