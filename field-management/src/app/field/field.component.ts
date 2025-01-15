import { Component } from '@angular/core';
import {FieldService} from '../service/field.service';

@Component({
  selector: 'app-field',
  standalone: false,

  templateUrl: './field.component.html',
  styleUrl: './field.component.css'
})
export class FieldComponent {

  field = {  available: false,location: '',name: '' };

  constructor(private fieldService: FieldService) {}

  onSubmit() {
    this.fieldService.createField(this.field).subscribe(response => {
      console.log('Field added successfully', response);
    });
  }

}
