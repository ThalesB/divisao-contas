import { Injectable } from '@angular/core';
import { Conta } from './model/conta.model';
import { ContaFinal } from './model/conta-final.model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DivisaoContasService {

  private url = 'http://localhost:8080/divisao-contas';

  
  constructor(private httpClient: HttpClient) { }

    
public calcular(conta: Conta): Observable<ContaFinal[]> {

    return this.httpClient.post<ContaFinal[]>(this.url, conta);
   }
}
