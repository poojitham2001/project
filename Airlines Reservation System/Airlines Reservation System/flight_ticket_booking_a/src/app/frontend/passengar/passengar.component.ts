
import { Component, Input, OnInit } from "@angular/core";
import { Router, ActivatedRoute } from '@angular/router';
import { Passengar } from "src/app/vehicle/services/passengar";
import { VehicleService } from "src/app/vehicle/services/vehicle.service"; 
import { Observable } from "rxjs/internal/Observable";

@Component({
  selector: 'app-passengar',
  templateUrl: './passengar.component.html',
  styleUrls: ['./passengar.component.css']
})
export class PassengarComponent implements OnInit {
  passengar: Observable<Passengar[]>;
  user_level_id = window.sessionStorage.user_level_id;
  id = ""

  constructor(private passengarService: VehicleService,
    private route: ActivatedRoute,
    private router: Router) {}

  ngOnInit() {
    this.id = window.sessionStorage.user_id;
    if(this.id) {
      this.reloadData(this.id);
    } else {
      this.reloadData(0);
    }
  }

  reloadData(id) {
    this.passengar = this.passengarService.getPassengarList(id);
  }

  public openNewTab(location) {
    window.open(location, '_blank');
  }

  deletePassengar(id: number) {
    this.passengarService.deletePassengar(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData(this.id);
        },
        error => console.log(error));
  }
}
