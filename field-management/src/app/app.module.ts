import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FieldComponent } from './field/field.component';
import { ReservationComponent } from './reservation/reservation.component';
import { HttpClientModule } from '@angular/common/http'; // Import HttpClientModule
import { FormsModule } from '@angular/forms';
import { IndexComponent } from './index/index.component';
import { ContactComponent } from './contact/contact.component';
import { BlogSingleComponent } from './blog-single/blog-single.component';
import { PortfolioDetailsComponent } from './portfolio-details/portfolio-details.component';



@NgModule({
  declarations: [
    AppComponent,
    FieldComponent,
    ReservationComponent,
    IndexComponent,
    ContactComponent,
    BlogSingleComponent,
    PortfolioDetailsComponent,

  
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
