import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AnalizadorComponent } from './analizador/analizador/analizador.component';
import { ServicioService } from './service/servicio.service';
import { HttpClientModule } from '@angular/common/http';
import { ResultadoComponent } from './analizador/analizador/resultado-analicis/resultado/resultado.component';
import { FormsModule } from '@angular/forms';
import { CompartirData } from './service/compartirdata';

@NgModule({
  declarations: [
    AppComponent,
    AnalizadorComponent,
    ResultadoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [ServicioService, CompartirData],
  bootstrap: [AppComponent]
})
export class AppModule { }
