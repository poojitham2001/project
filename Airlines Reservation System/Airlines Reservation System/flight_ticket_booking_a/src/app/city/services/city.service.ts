import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { City } from './city';

@Injectable({
  providedIn: 'root'
})
export class CityService {

  private baseUrl = 'http://127.0.0.1:8080/api/v1/city';

  constructor(private http: HttpClient) { }

  getCity(id: number): Observable<City> {
    return this.http.get<City>(`${this.baseUrl}/${id}`);
  }

  createCity(city: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, city);
  }

  updateCity(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  updateUploadCity(id: number, city: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/${id}`, city);
  }

  deleteCity(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getCitiesList(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/all-cities/${id}`);
  }

  getAllCities(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
