import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Vehicle } from './vehicle';
import { Passengar } from './passengar';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  private baseUrl = 'http://127.0.0.1:8080/api/v1/vehicle';

  constructor(private http: HttpClient) { }

  getVehicle(id: number): Observable<Vehicle> {
    return this.http.get<Vehicle>(`${this.baseUrl}/${id}`);
  }
  getVehicleDetails(id: number): Observable<Vehicle> {
    return this.http.get<Vehicle>(`${this.baseUrl}/vehicle-details/${id}`);
  }

  getRouteDetails(id: number): Observable<Vehicle> {
    return this.http.get<Vehicle>(`http://127.0.0.1:8080/api/v1/route/route-details/${id}`);
  }

  createVehicle(vehicle: FormData): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, vehicle);
  }

  saveComment(comment: Passengar): Observable<Object> {
    return this.http.post(`http://127.0.0.1:8080/api/v1/passengar`, comment);
  }

  updateVehicle(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  updateUploadVehicle(id: number, vehicle: FormData): Observable<Object> {
    return this.http.post(`${this.baseUrl}/${id}`, vehicle);
  }

  deleteVehicle(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  deletePassengar(id: number): Observable<any> {
    return this.http.delete(`http://127.0.0.1:8080/api/v1/passengar/${id}`, { responseType: 'text' });
  }

  getVehicleList(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/all-vehicle/${id}`);
  }

  filterVehicleList(from: String, to: String): Observable<any> {
    return this.http.get(`http://127.0.0.1:8080/api/v1/route/search/${from}/${to}`);
  }

  getPassengarList(id: number): Observable<any> {
    return this.http.get(`http://127.0.0.1:8080/api/v1/passengar/all-users-passengar/${id}`);
  }

  getAllVehicle(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getAllPassengar(id: number): Observable<any> {
    return this.http.get(`http://127.0.0.1:8080/api/v1/passengar/all-passengar/${id}`);
  }
}
