import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {catchError, Observable, throwError} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FieldService {
  private apiUrl = 'http://localhost:8888/FIELDS-SERVICE/api/fields';  // URL to backend API

  constructor(private http: HttpClient) {}

  // Get all fields
  getFields(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  // Create a new field
  createField(field: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, field).pipe(
      catchError(error => {
        console.error('Error creating field', error);
        return throwError(error); // You can rethrow the error or handle it as needed
      })
    );
  }


  // Update an existing field
  updateField(id: number, field: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/${id}`, field);  // Make PUT request
  }

  // Delete a field
  deleteField(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);  // Make DELETE request
  }
}
