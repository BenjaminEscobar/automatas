import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CompartirData {

  private cadenaEnviada: string = '';

  constructor(private http: HttpClient) { }

  setSharedData(data: string) {
    this.cadenaEnviada = data;
  }

  getSharedData(): string {
    return this.cadenaEnviada;
  }
    

}
