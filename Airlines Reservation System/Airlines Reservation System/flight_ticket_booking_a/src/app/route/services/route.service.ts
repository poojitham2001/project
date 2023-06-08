import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Route } from './route';

@Injectable({
  providedIn: 'root'
})
export class RouteService {

  private baseUrl = 'http://127.0.0.1:8080/api/v1/route';

  constructor(private http: HttpClient) { }

  getRoute(id: number): Observable<Route> {
    return this.http.get<Route>(`${this.baseUrl}/${id}`);
  }
  getRouteDetails(id: number): Observable<Route> {
    return this.http.get<Route>(`${this.baseUrl}/route-details/${id}`);
  }

  createRoute(route: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, route);
  }

  updateRoute(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  updateUploadRoute(id: number, route: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/${id}`, route);
  }

  deleteRoute(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  deletePassengar(id: number): Observable<any> {
    return this.http.delete(`http://127.0.0.1:8080/api/v1/passengar/${id}`, { responseType: 'text' });
  }

  getRouteList(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/all-route/${id}`);
  }

  filterRouteList(search: String): Observable<any> {
    return this.http.get(`${this.baseUrl}/all-search/${search}`);
  }

  getPassengarList(id: number): Observable<any> {
    return this.http.get(`http://127.0.0.1:8080/api/v1/passengar/all-users-passengar/${id}`);
  }

  getAllRoute(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getAllPassengar(id: number): Observable<any> {
    return this.http.get(`http://127.0.0.1:8080/api/v1/passengar/all-passengar/${id}`);
  }
}
