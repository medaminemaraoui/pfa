import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FieldComponent } from './field/field.component';
import { ReservationComponent } from './reservation/reservation.component';
import { HttpClientModule } from '@angular/common/http'; // Import HttpClientModule
import { FormsModule } from '@angular/forms';  // For ngModel

@NgModule({
  declarations: [
    AppComponent,
    FieldComponent,
    ReservationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,  // Ensure HttpClientModule is here
    FormsModule,  // For two-way data binding with ngModel
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
