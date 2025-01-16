import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {FieldComponent} from './field/field.component';
import {ReservationComponent} from './reservation/reservation.component';
import { IndexComponent } from './index/index.component';
import { PortfolioDetailsComponent } from './portfolio-details/portfolio-details.component';
import { BlogSingleComponent } from './blog-single/blog-single.component';
import { ContactComponent } from './contact/contact.component';



const routes: Routes = [
  {path:"fields",component :FieldComponent},
  {path:"reservations",component :ReservationComponent},
  { path: '', redirectTo: '/fields', pathMatch: 'full' },
  { path: '', redirectTo: '/index', pathMatch: 'full' },
  {path:"index",component:IndexComponent},

  {path:"portfolio",component:PortfolioDetailsComponent},
  {path:"blog",component:BlogSingleComponent},
  {path:"contact",component:ContactComponent}
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
