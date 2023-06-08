import { CategoryService } from "src/app/category/services/category.service"; 
import { Category } from "src/app/category/services/category";
import { Component, OnInit } from "@angular/core";
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from "rxjs/internal/Observable";
import { Vehicle } from "src/app/vehicle/services/vehicle";
import { VehicleService } from "src/app/vehicle/services/vehicle.service";
import { CityService } from "src/app/city/services/city.service";
import { City } from "src/app/city/services/city";

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  categories: Observable<Category[]>;
  user_level_id = window.sessionStorage.user_level_id;

  vehicle: Observable<Vehicle[]>;
  from_city = "0"
  to_city = "0"
  total_passengar = "0"
  booking_date = "";
  city: City = new City();
  showData = 0;

  constructor(private vehicleService: VehicleService,
    private cityService: CityService,
    private route: ActivatedRoute,
    private router: Router) {}

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    this.getCityOption();
    this.vehicle = this.vehicleService.filterVehicleList("0", "0");
  }

  reloadData(id) {
    this.vehicle = this.vehicleService.filterVehicleList("0", "0");
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
    this.router.navigate(['/vehicle']);   
  }
  
  resetSearch() {
    this.vehicle = this.vehicleService.filterVehicleList("0", "0");
  }
}
