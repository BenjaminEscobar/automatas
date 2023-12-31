import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServicioService {

  private apiUrl = 'http://localhost:8080/'

  constructor(private http: HttpClient) { }

  getAnalisis(cadena: string): Observable<any>{
    return this.http.post(this.apiUrl + 'analizador', cadena);
  }

}
