import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Employee } from './employee';
import { EmployeeService } from './employee.service';
import { HttpClient, HttpClientModule, HttpErrorResponse } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule, NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CommonModule, HttpClientModule, FormsModule],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'employeemanagerapp';
  public employees: Employee[] = [];
  public deleteEmployee!: Employee;
  public editEmployee!: Employee;

  constructor(private employeeService: EmployeeService) {}

  ngOnInit(): void {
    this.getEmployees();
  }

  public getEmployees(): void {
    this.employeeService.getEmployees().subscribe(
      (response: Employee[]) => {
        console.log('Employees fetched:', response);
        this.employees = response;
      },
      (error: HttpErrorResponse) => {
        console.error(error.message);
      }
    );
  }

  public onAddEmployee(addForm: NgForm): void {
    this.employeeService.createEmployee(addForm.value).subscribe(
      (response: Employee) => {
        this.getEmployees();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateEmployee(employee: Employee): void {
    this.employeeService.updateEmployee(employee).subscribe(
      (response: Employee) => {
        this.getEmployees();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteEmployee(id: number): void {
    this.employeeService.deleteEmployee(id).subscribe(
      (response: void) => {
        this.getEmployees();
      },
      (error: HttpErrorResponse) => {
        alert('Not deleted!');
      }
    );
  }

  public searchEmployees(key: string): void {
    if (!key) {
      this.getEmployees();
      return;
    }
  
    const lowerCaseKey = key.toLowerCase();
    const results: Employee[] = [];
  
    for (const employee of this.employees) {
      if (
        (employee.firstName?.toLowerCase() || '').includes(lowerCaseKey) ||
        (employee.lastName?.toLowerCase() || '').includes(lowerCaseKey) ||
        (employee.email?.toLowerCase() || '').includes(lowerCaseKey) ||
        (employee.phone?.toLowerCase() || '').includes(lowerCaseKey) ||
        (employee.jobTitle?.toLowerCase() || '').includes(lowerCaseKey)
      ) {
        results.push(employee);
      }
    }

    this.employees = results;
  }
  


public onOpenModal(employee: Employee | null, mode: string): void {
  const addModal = document.getElementById('addEmployeeModal');
  const editModal = document.getElementById('updateEmployeeModal');
  const deleteModal = document.getElementById('deleteEmployeeModal');

  // Reset all modals to hidden
  if (addModal) addModal.classList.remove('show');
  if (editModal) editModal.classList.remove('show');
  if (deleteModal) deleteModal.classList.remove('show');

  // Open specific modal
  if (mode === 'add' && addModal) {
    addModal.classList.add('show');
  }
  if (mode === 'edit' && editModal && employee) {
    this.editEmployee = employee;
    editModal.classList.add('show');
  }
  if (mode === 'delete' && deleteModal && employee) {
    this.deleteEmployee = employee;
    deleteModal.classList.add('show');
  }
}


public onCloseModal(): void {
  const modals = document.querySelectorAll('.modal');
  modals.forEach((modal) => modal.classList.remove('show'));
}


 }
