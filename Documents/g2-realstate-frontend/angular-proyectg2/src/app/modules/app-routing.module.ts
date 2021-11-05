import { HtmlParser } from '@angular/compiler';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormularioIComponent } from '../components/formulario-i/formulario-i.component';
import { FormularioInteresadoComponent } from '../components/formulario-interesado/formulario-interesado.component';
import { FormularioVComponent } from '../components/formulario-v/formulario-v.component';
import { HomeComponent } from '../components/home/home.component';
import { PageNotFoundComponent } from '../components/page-not-found/page-not-found.component';
import { ViviendaDetailsComponent } from '../vivienda-details/vivienda-details.component';
import { ViviendaListComponent } from '../vivienda-list/vivienda-list.component';

const routes: Routes = [
  {path:'home', component: HomeComponent},
  {path:'formulario-i', component: FormularioIComponent},
  {path:'formulario-interado', component: FormularioInteresadoComponent},
  {path:'formulario-v', component: FormularioVComponent},
  {path:'vivienda/:id', component: ViviendaDetailsComponent},
  {path:'vivienda-list', component: ViviendaListComponent},
  { path: '', pathMatch: 'full', redirectTo: '/home'}, // Carga del componente por defecto
  { path: '**', component: PageNotFoundComponent } // Carga cuando no ha encontrado otra coincidencia

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
