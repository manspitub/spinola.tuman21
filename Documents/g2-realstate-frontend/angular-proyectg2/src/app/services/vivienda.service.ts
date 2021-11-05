import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ViviendaListResponse } from '../interfaces/vivienda-list.interface';
import { ViviendaResponse } from '../interfaces/vivienda.interface';

const API_BASE_URL = 'http://localhost:8080';

@Injectable({
  providedIn: 'root'
})
export class ViviendaService {

  constructor(private http: HttpClient) { }

  /*getViviendaList(): Observable<Vivienda> {
    return this.http.get<Vivienda>(`${API_BASE_URL}/vivienda/`);
  }*/
  getViviendaList(): Observable<ViviendaListResponse> {
    return this.http.get<ViviendaListResponse>(`${API_BASE_URL}/vivienda/`);
  }

  getVivienda(id: number): Observable<ViviendaResponse>{
    return this.http.get<ViviendaResponse>(`${API_BASE_URL}vivienda/${id}/`)
  }

}

