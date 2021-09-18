import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  employee : Employee = new Employee();

  constructor(private employeeService : EmployeeService,
              private router : Router) { }

  saveEmployee(){
    this.employeeService.createEmployee(this.employee).subscribe(date => {
      console.log(date);
      this.goToEmplopyeeList();

    },error => console.log(error));
  }

  goToEmplopyeeList(){
    this.router.navigate(['/employees']);
  }
  ngOnInit(): void {
  }

  ngSubmit() {
    this.saveEmployee();
    console.log(this.employee);
  }


}
