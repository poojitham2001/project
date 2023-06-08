
import { Component, EventEmitter, OnInit, Output } from "@angular/core";
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from "rxjs/internal/Observable";
import { OrdersService } from "src/app/orders/services/orders.service"; 
import { Orders } from "src/app/orders/services/orders"; 
import { TokenStorageService } from '../../services/token-storage.service';
import { VehicleService } from "src/app/vehicle/services/vehicle.service";
import { Vehicle } from "src/app/vehicle/services/vehicle";
import { Passengar } from "src/app/vehicle/services/passengar";


@Component({
  selector: 'app-order-items',
  templateUrl: './order-items.component.html',
  styleUrls: ['./order-items.component.css']
})
export class OrderItemsComponent implements OnInit {
  Vehicle: Observable<Vehicle[]>;
  orders: Orders = new Orders();
  passengar: Observable<any[]>;

  constructor(
    private vehicleService: VehicleService,
    private route: ActivatedRoute,
    private ordersService: OrdersService,
    private router: Router) {}
    order_id = this.route.snapshot.paramMap.get('id');

  ngOnInit() {
   
    console.log("Getting Order ID "+this.order_id)
    this.getAllPassengar(this.order_id);
    this.getOrders(this.order_id);
    console.log("I am here");
  }

  getAllPassengar(id) {
    this.passengar = this.vehicleService.getAllPassengar(id);
    console.log(this.passengar)
  }

  getOrders(id): void {
    this.ordersService.getOrderDetails(id).subscribe(
      data => {
        console.log(data);
        this.orders = data[0];
      },
      err => {
        console.log(err);
      }
    );

  }
}
