import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {FieldComponent} from './field/field.component';
import {ReservationComponent} from './reservation/reservation.component';

const routes: Routes = [
  {path:"fields",component :FieldComponent},
  {path:"reservations",component :ReservationComponent},
  { path: '', redirectTo: '/fields', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
