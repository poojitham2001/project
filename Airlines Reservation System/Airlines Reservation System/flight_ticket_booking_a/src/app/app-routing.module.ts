
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginLayoutComponent } from './layouts/login-layout/login-layout.component';
import { PageLayoutComponent } from './layouts/page-layout/page-layout.component';
import { HomePageComponent } from './frontend/home-page/home-page.component';
import { AboutPageComponent } from './frontend/about-page/about-page.component';
import { ContactPageComponent } from './frontend/contact-page/contact-page.component';
import { CategoryComponent } from './frontend/category/category.component';
import { VehicleListingComponent } from './frontend/vehicle-listing/vehicle-listing.component';
import { VehicleDetailsComponent } from './frontend/vehicle-details/vehicle-details.component';
import { LoginComponent } from './frontend/login/login.component';
import { CustomerComponent } from './frontend/customer/customer.component';
import { DashboardComponent } from './frontend/dashboard/dashboard.component';
import { PassengarComponent } from './frontend/passengar/passengar.component';
import { FeedbackPageComponent } from './frontend/feedback-page/feedback-page.component';
import { CompanyComponent } from './frontend/company/company.component';
import { PaymentComponent } from './frontend/payment/payment.component';
import { OrderReportComponent } from './frontend/order-report/order-report.component';
import { VehicleCartComponent } from './frontend/vehicle-cart/vehicle-cart.component';
import { OrderItemsComponent } from './frontend/order-items/order-items.component';



const routes: Routes = [
  // Site routes goes here 
  { 
    path: '', 
    component: LoginLayoutComponent ,
    children: [
      
      { path: '', component: HomePageComponent },
      { path: 'about', component: AboutPageComponent },
      { path: 'login', component: LoginComponent },
      { path: 'register', component: CustomerComponent },
      { path: 'contact', component: ContactPageComponent },
      { path: 'payment', component: PaymentComponent },
      { path: 'order-report', component: OrderReportComponent },
      { path: 'category', component: CategoryComponent },
      { path: 'company', component: CompanyComponent },
      { path: 'vehicle', component: VehicleListingComponent },
      { path: 'vehicle/:id', component: VehicleListingComponent },
      { path: 'vehicle-details/:id', component: VehicleDetailsComponent },
      { path: 'order-items/:id', component: OrderItemsComponent },
      { path: 'vehicle-cart', component: VehicleCartComponent },
      { path: 'dashboard', component: DashboardComponent },
      { path: 'my-passengar', component: PassengarComponent },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
