import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Employee } from './employee';
import { EmployeeService } from './employee.service';
import { HttpClient, HttpClientModule, HttpErrorResponse, provideHttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { bootstrapApplication } from '@angular/platform-browser';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,CommonModule, HttpClientModule],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'employeemanagerapp';
  public employees: Employee[];

  constructor(private employeeService: EmployeeService) { 
    this.employees = [];
  }
  ngOnInit() {
    this.getEmployees();
    // throw new Error('Method not implemented.');
  }

  public getEmployees(): void {
    this.employeeService.getEmployees().subscribe((response: Employee[]) => {
      this.employees = response;
    },
    (error: HttpErrorResponse) => {
      alert(error.message);
    }
  );
  }
    
}
