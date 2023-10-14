import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Atributo } from 'src/app/model/atributo';
import { TokenAnalizador } from 'src/app/model/token';
import { CompartirData } from 'src/app/service/compartirdata';
import { ServicioService } from 'src/app/service/servicio.service';

@Component({
  selector: 'app-analizador',
  templateUrl: './analizador.component.html',
  styleUrls: ['./analizador.component.css']
})
export class AnalizadorComponent implements OnInit {
  cadena: string = "";

  constructor(private router: Router, private infoCompartida: CompartirData) { }

  ngOnInit(): void {

  }

  obtieneAnalisis(){
    this.infoCompartida.setSharedData(this.cadena);
    this.router.navigate(['/resultado']);
  }

}
