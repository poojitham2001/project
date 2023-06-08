
import { Component, Input, OnInit } from "@angular/core";
import { Router, ActivatedRoute } from '@angular/router';

import { TokenStorageService } from '../../services/token-storage.service';
import { Payment } from "./services/payment";
import { PaymentService } from "./services/payment.service";
import { DatePipe } from '@angular/common';
import { VehicleService } from "src/app/vehicle/services/vehicle.service";
import { OrdersService } from "src/app/orders/services/orders.service";
import { Route } from "src/app/route/services/route";


@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css'],
  providers: [DatePipe]
})
export class PaymentComponent implements OnInit {
  
  @Input() orderForm: any = {};
  user_level_id = window.sessionStorage.user_level_id;
  user_id = window.sessionStorage.user_id;
  order_id = window.sessionStorage.order_id;
  vehicle: Route = new Route();
  submitted = false;
  isUpdate = false;
  msg = "";
  type= "danger";
  payment_id = "save"
  totalCost = 0;
  readonly = false;
  user = this.tokenStorageService.getUser();

  registrationMessage: string = ""


 
  constructor(
    private tokenStorageService: TokenStorageService,
    private orderService:OrdersService,
    private paymentService: PaymentService,
    private route: ActivatedRoute,
    private router: Router,
    private datePipe: DatePipe,
    private vehicleService: VehicleService,
  ) { }

  ngOnInit() {
    this.getTotalAmount();
  }

  
  getTotalAmount() {
    console.log("Fare : "+window.sessionStorage.ticket_type);
    this.vehicleService.getAllPassengar(this.order_id)
    .subscribe(
      data => {
        data.forEach( (element) => {
          this.totalCost+=Number(window.sessionStorage.ticket_type);
        });
      },
      error => console.log(error));
  }

  save(): void {
    let myDate = new Date();
    let todayDate = this.datePipe.transform(myDate, 'dd MMM yyyy hh:mm a');
    this.orderForm.order_total = this.totalCost;
    this.orderForm.order_customer_id = this.user_id;
    this.orderForm.order_status = "Paid";
    this.orderForm.order_id = this.order_id;
    this.orderForm.order_date = todayDate;
    this.orderForm.order_route_id = window.sessionStorage.route_id;
    this.orderForm.order_travel_date = window.sessionStorage.booking_date;

    this.orderService.updateOrders(this.order_id, this.orderForm).subscribe(
      data => {
        console.log("Order ID : ");
        console.log(data);
        this.router.navigate(['/order-items/'+this.order_id]);
        this.order_id = "";
        window.sessionStorage.order_id = "";
      },
      err => {
        // this.errorMessage = err.error.message;
        // this.isSignUpFailed = true;
      }
    );
  }

  onSubmit() {
    this.save();    
  }
}
