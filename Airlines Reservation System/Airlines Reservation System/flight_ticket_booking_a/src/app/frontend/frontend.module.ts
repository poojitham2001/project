import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomePageComponent } from './home-page/home-page.component';
import { AboutPageComponent } from './about-page/about-page.component';
import { ContactPageComponent } from './contact-page/contact-page.component';
import { FrontendHeaderComponent } from './frontend-header/frontend-header.component';
import { FrontendFooterComponent } from './frontend-footer/frontend-footer.component';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'; // <== add the imports!
import { RouterModule } from '@angular/router';
import { CategoryComponent } from './category/category.component';
import { VehicleListingComponent } from './vehicle-listing/vehicle-listing.component';
import { VehicleDetailsComponent } from './vehicle-details/vehicle-details.component';
import { LoginComponent } from './login/login.component';
import { CustomerComponent } from './customer/customer.component';
import { DashboardComponent } from './dashboard/dashboard.component'; 
import { PassengarComponent } from './passengar/passengar.component'; 
import { FeedbackPageComponent } from './feedback-page/feedback-page.component';
import { CompanyComponent } from './company/company.component';
import { PaymentComponent } from './payment/payment.component';
import { OrderReportComponent } from './order-report/order-report.component';
import { VehicleCartComponent } from './vehicle-cart/vehicle-cart.component';
import { OrderItemsComponent } from './order-items/order-items.component';

@NgModule({
  declarations: [
    HomePageComponent, 
    AboutPageComponent, 
    ContactPageComponent, 
    FeedbackPageComponent,
    FrontendHeaderComponent, 
    FrontendFooterComponent, 
    CategoryComponent, 
    VehicleListingComponent, 
    VehicleDetailsComponent,
    LoginComponent,
    CustomerComponent,
    DashboardComponent,
    PassengarComponent,
    CompanyComponent,
    PaymentComponent,
    OrderReportComponent,
    VehicleCartComponent,
    OrderItemsComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    ReactiveFormsModule,
    FormsModule,
    RouterModule
  ]
})
export class FrontendModule { }
