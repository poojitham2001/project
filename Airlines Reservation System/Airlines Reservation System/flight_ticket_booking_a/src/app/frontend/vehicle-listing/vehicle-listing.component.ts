import { VehicleService } from "src/app/vehicle/services/vehicle.service"; 
import { CategoryService } from "src/app/category/services/category.service"; 
import { Category } from "src/app/category/services/category";
import { Vehicle } from "src/app/vehicle/services/vehicle";
import { Component, OnInit } from "@angular/core";
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from "rxjs/internal/Observable";
import { City } from "src/app/city/services/city";
import { CityService } from "src/app/city/services/city.service";
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-vehicle-listing',
  templateUrl: './vehicle-listing.component.html',
  styleUrls: ['./vehicle-listing.component.css'],
  providers: [DatePipe]
})
export class VehicleListingComponent implements OnInit {

  vehicle: Observable<Vehicle[]>;
  from_city = "0"
  to_city = "0"
  total_passengar = "0"
  booking_date = "";
  user_level_id = window.sessionStorage.user_level_id;
  city: City = new City();
  error = "success";
  showData = 0 ;
  msg = "Kindly search your flight. Select cities and dates !!!";
  myyDate = new Date();
  todayDate = "";

  constructor(private vehicleService: VehicleService,
    private cityService: CityService,
    private datePipe: DatePipe,
    private route: ActivatedRoute,
    private router: Router) {
      this.todayDate = this.datePipe.transform(this.myyDate, 'yyyy-MM-dd');
    }

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    this.getCityOption();
  }

  reloadData(id) {
    this.vehicle = this.vehicleService.filterVehicleList("0", "0");
  }
  

  public openNewTab(location) {
    window.open(location, '_blank');
  }

  getCityOption(): void {
    this.cityService.getAllCities().subscribe(
      data => {
        console.log(data);
        this.city = data;
      },
      err => {
        console.log(err);
      }
    );
  }

  searchVehicle() {
    this.showData = 1;
    if(this.from_city == "") {
      this.vehicle = this.vehicleService.filterVehicleList("0", "0");
    } else {
      window.sessionStorage.from_city = this.from_city;
      window.sessionStorage.to_city = this.to_city;
      window.sessionStorage.total_passengar = this.total_passengar;
      window.sessionStorage.booking_date = this.booking_date;

      this.vehicleService.filterVehicleList(this.from_city, this.to_city).subscribe(
        data => {
          this.showData = 1;
          this.vehicle = data;
          if(Object.keys(this.vehicle).length == 0) {
              this.showData = 0;
              this.error = "danger"
              this.msg = "No Flight Found on this route. Kindly choose different route !!!";
          }
        },
        err => {
          
        }
      );      
    }    
  }
  
  resetSearch() {
    this.vehicle = this.vehicleService.filterVehicleList("0", "0");
  }
}
