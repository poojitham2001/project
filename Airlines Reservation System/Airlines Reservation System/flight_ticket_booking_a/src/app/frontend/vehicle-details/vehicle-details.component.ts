import { VehicleService } from "src/app/vehicle/services/vehicle.service"; 
import { CategoryService } from "src/app/category/services/category.service"; 
import { Category } from "src/app/category/services/category";
import { Vehicle } from "src/app/vehicle/services/vehicle";
import { Component, OnInit } from "@angular/core";
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from "rxjs/internal/Observable";
import { Passengar } from "src/app/vehicle/services/passengar";
import { DatePipe } from '@angular/common';
import { Sell } from "src/app/sell/services/sell";
import { SellService } from "src/app/sell/services/sell.service";
import { OrdersService } from "src/app/orders/services/orders.service";
import { Orders } from "src/app/orders/services/orders";
import { Route } from "src/app/route/services/route";

@Component({
  selector: 'app-vehicle-details',
  templateUrl: './vehicle-details.component.html',
  styleUrls: ['./vehicle-details.component.css'],
  providers: [DatePipe]
})
export class VehicleDetailsComponent implements OnInit {
  id =""
  order_id = 0;
  user_level_id = window.sessionStorage.user_level_id;
  user_id = window.sessionStorage.user_id;
  vehicle: Route = new Route();
  sellForm: Sell = new Sell();
  orderForm: Orders = new Orders();
  ticket_type = "0";
  error = 0;
  msg = "";
  
  commentFrm: Passengar = new Passengar();
  category: Category = new Category();
  vehicleList: Observable<Vehicle[]>;
  categories: Observable<Category[]>;
  passengar: Observable<Passengar[]>;
  formData = new FormData();
  comment_date = new Date();

  constructor(
    private categoryService: CategoryService,
    private vehicleService: VehicleService,
    private route: ActivatedRoute,
    private router: Router,
    private datePipe: DatePipe,
    private sellService: SellService,
    private orderService: OrdersService
  ) { }

  ngOnInit() {
    this.id = this.route.snapshot.paramMap.get('id');
    window.sessionStorage.route_id = this.id;
    console.log("ID : "+this.id)
    if (this.id) {
      this.getVehicle(this.id);
    } 
    this.commentFrm.passengar_gender = "0";
    this.ticket_type = "0";
    this.getAllPassengar(window.sessionStorage.order_id);
  }

  onSubmit() {
    if(this.user_id) {
      if(window.sessionStorage.order_id) {
        this.commentFrm.passengar_booking_id = window.sessionStorage.order_id;
        this.commentFrm.passengar_user_id = window.sessionStorage.user_id;
        this.save(); 
      } else {
        this.saveOrder();
      }
    } else {
      this.router.navigate(['/login']);
    }
  }
 
  book_ticket() {
    console.log("Passengar Details  : ");
    console.log(this.passengar);
    console.log(Object.keys(this.passengar).length);
    if(Object.keys(this.passengar).length == 0) {
      this.error = 1
      this.msg = "Kindly add atleast 1 Passengar to book the ticket !!!";
    }
    else if(this.ticket_type == "0") {
      this.error = 1;
      this.msg = "Kindly select ticket type from drop down !!!";
    } else {
      window.sessionStorage.ticket_type = this.ticket_type;
      this.router.navigate([ '/payment']);
    }
  }


  save() {    
    this.vehicleService.saveComment(this.commentFrm).subscribe(
      data => {
        console.log(data);
        this.getAllPassengar(window.sessionStorage.order_id);
        this.commentFrm.passengar_name = "";
        this.commentFrm.passengar_age = "";
        this.commentFrm.passengar_gender = "0";
        this.router.navigate(['/vehicle-details/'+this.id]);
      },
      err => {
        // this.errorMessage = err.error.message;
        // this.isSignUpFailed = true;
      }
    );
  }

  getVehicle(id: any): void {
    this.vehicleService.getRouteDetails(id).subscribe(
      data => {
        console.log(data);
        this.vehicle = data[0];
      },
      err => {
        console.log(err);
      }
    );

  }

  getAllPassengar(id) {
    this.vehicleService.getAllPassengar(id).subscribe(
      data => {
        this.passengar = data;
      },
      err => {
        
      }
    ); 
  }
  
  saveOrder(): void {
    let myDate = new Date();
    let todayDate = this.datePipe.transform(myDate, 'dd MMM yyyy hh:mm a');
    console.log("Date = "+todayDate);
    this.orderForm.order_date = todayDate;
    this.orderForm.order_customer_id = this.user_id;
    this.orderForm.order_route_id = window.sessionStorage.route_id;
    this.orderForm.order_travel_date = "NA";
    this.orderForm.order_total = 0;
    this.orderForm.order_status = "In Progress";
    this.addOrder();
      
  }

  addOrder(): void {
    this.orderService.createOrders(this.orderForm).subscribe(
      data => {
        console.log(data);
        window.sessionStorage.order_id = data['order_id'];
        console.log("Order ID : "+window.sessionStorage.order_id);
        this.onSubmit();
      },
      err => {
        // this.errorMessage = err.error.message;
        // this.isSignUpFailed = true;
      }
    );
  }

}
