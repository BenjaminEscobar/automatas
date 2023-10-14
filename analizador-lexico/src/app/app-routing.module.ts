import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AnalizadorComponent } from './analizador/analizador/analizador.component';
import { ResultadoComponent } from './analizador/analizador/resultado-analicis/resultado/resultado.component';

const routes: Routes = [
  {path: '', component: AnalizadorComponent, pathMatch: 'full'},
  {path: 'resultado', component: ResultadoComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
