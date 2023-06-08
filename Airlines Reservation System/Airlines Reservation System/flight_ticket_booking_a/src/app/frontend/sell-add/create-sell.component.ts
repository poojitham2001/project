import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { VehicleService } from 'src/app/vehicle/services/vehicle.service'; 
import { Vehicle } from 'src/app/vehicle/services/vehicle'; 

import { SellService } from 'src/app/sell/services/sell.service';
import { Sell } from 'src/app/sell/services/sell';
import { OrdersService } from 'src/app/orders/services/orders.service';

import { TokenStorageService } from 'src/app/services/token-storage.service'; 
import { DatePipe } from '@angular/common';
import { Orders } from 'src/app/orders/services/orders';


@Component({
  selector: 'app-create-sell',
  templateUrl: './create-sell.component.html',
  styleUrls: ['./create-sell.component.css'],
  providers: [DatePipe]
})
export class CreateSellComponent implements OnInit {
  @Input() sellForm: any = {};
  @Input() orderForm: any = {};
  isLoggedIn = false;
  sell: Sell[];
  sellDetails: Orders;
  vehicle: Vehicle[];
  isSuccessful = false;
  vehicleType = {};
  isSignUpFailed = false;
  errorMessage = '';
  isUpdate = false;
  order_id = 0;
  order_total = 0;

  constructor(
    private vehicleService: VehicleService,
    private sellService: SellService,
    private orderService:OrdersService,
    private tokenStorageService: TokenStorageService,
    private router: Router,
    private route: ActivatedRoute,
    private datePipe: DatePipe
  ) { }

  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorageService.getToken();
    
    this.sellForm.sell_vehicle_id = 0;
    if (this.isLoggedIn) {
     
    } else {
      console.log("Redirecting to login");
      this.router.navigate(['/login']);
    }

  }

  getOrderDetails(order_id): void {
    this.orderService.getOrders(order_id).subscribe(
      data => {
        console.log("Order Details : ")
        console.log(data);
        this.sellDetails = data;
      },
      err => {
        this.sell = JSON.parse(err.error).message;
      }
    );
  }

  getOrderItems(order_id): void {
    this.sellService.getSellList(order_id).subscribe(
      data => {
        console.log(data);
        this.sell = data;
        this.totalAmount();
      },
      err => {
        this.sell = JSON.parse(err.error).message;
      }
    );
  }

  getAllVehicle(): void {
    this.vehicleService.getAllVehicle().subscribe(
      data => {
        console.log(data);
        this.vehicle = data;
      },
      err => {
        console.log(err);
      }
    );
  }

  filterData(vehicle_id) {
    return this.vehicle.filter(object => {
      return object['vehicle_id'] == vehicle_id;
    });
  }

  saveItemList(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      // this.updateVehicle();
    } else {
      let vehicle_id = this.sellForm.sell_vehicle_id;
      let vehicleDetails = this.filterData(vehicle_id);
      this.sellForm.sell_order_id = this.order_id;
      this.sellForm.sell_price_per_unit = 0;
      this.sellForm.sell_total_cost = 0;
      this.addItem();
    }
  }

  saveOrder(): void {
    const id = this.route.snapshot.paramMap.get('id');
    let myDate = new Date();
    let todayDate = this.datePipe.transform(myDate, 'dd MMM yyyy hh:mm a');
    console.log("Date = "+todayDate);
    if (id) {
      // this.updateVehicle();
    } else {
      this.orderForm.order_date = todayDate;
      this.orderForm.order_total = 0;
      this.orderForm.order_status = "In Progress";
      this.addOrder();
      
    }
  }

  saveSells(): void {
      this.orderForm.order_id = this.order_id
      this.orderForm.order_total = this.order_total;
      this.orderForm.order_status = "Paid";
      this.updateOrder();
  }

  updateOrder(): void {
    this.orderService.updateOrders(this.order_id, this.orderForm).subscribe(
      data => {
        console.log("Order ID : ");
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
        this.router.navigate(['/sells/'+this.order_id]);
        
      },
      err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    );
  }

  addOrder(): void {
    this.orderService.createOrders(this.orderForm).subscribe(
      data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
        this.order_id = data['order_id'];
        console.log("Order ID : "+this.order_id);
        this.getOrderDetails(this.order_id);
        this.getAllVehicle();
      },
      err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    );
  }

  addItem(): void {
    this.sellService.createSell(this.sellForm).subscribe(
      data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
        this.sellForm.sell_units = 0;
        this.sellForm.sell_vehicle_id = 0;
        this.getOrderItems(this.order_id);
        
      },
      err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    );
  }

  delete(id: number): void {
    this.sellService.deleteSell(id).subscribe(
      data => {
        console.log(data);
        this.getOrderItems(this.order_id);
      },
      err => {
        console.log(err);
      }
    );
  }

  totalAmount() {
    this.order_total = 0; 
    this.sell.forEach(element => {
      this.order_total += Number(element.sell_total_cost);
    });
  }

  reloadPage(): void {
    window.location.reload();
  }

}
