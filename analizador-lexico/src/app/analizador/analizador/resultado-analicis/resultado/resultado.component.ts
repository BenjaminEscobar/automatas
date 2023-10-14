import { Component, OnInit } from '@angular/core';
import { Atributo } from 'src/app/model/atributo';
import { TokenAnalizador } from 'src/app/model/token';
import { ServicioService } from 'src/app/service/servicio.service';
import { ActivatedRoute } from '@angular/router';
import { CompartirData } from 'src/app/service/compartirdata';

@Component({
  selector: 'app-resultado',
  templateUrl: './resultado.component.html',
  styleUrls: ['./resultado.component.css']
})
export class ResultadoComponent implements OnInit {


  token: TokenAnalizador[] = [];
  atributo: Atributo[] = [];
  clase: string = "";

  constructor(private servicio: ServicioService, private route: ActivatedRoute, private infoData: CompartirData) { }

  ngOnInit(): void {
    this.realizarAnalisis();
  }

  realizarAnalisis() {
    this.route.params.subscribe(params => {
      let cadena = this.infoData.getSharedData();
      this.servicio.getAnalisis(cadena).subscribe(res => {
        this.token = res.listaToken
        this.atributo = res.listaAtributo
        this.clase = res.nombreClase;
      });
    })
  }

  regresar() {
    window.history.back();
  }

}
