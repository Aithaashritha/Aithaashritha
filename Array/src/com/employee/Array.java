package com.employee;

import java.util.Scanner;

class Employee {
    private int empID;
    private String empName;
    private double salary;

    public void setEmpID(int empID) { this.empID = empID; }
    public int getEmpID() { return empID; }

    public void setEmpName(String empName) { this.empName = empName; }
    public String getEmpName() { return empName; }

    public void setSalary(double salary) { this.salary = salary; }
    public double getSalary() { return salary; }

    public void displayEmployeeDetails() {
        System.out.println("ID: " + empID + " | Name: " + empName + " | Salary: ₹" + salary);
    }
}

public class Array {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        // Create array of Employee objects
        Employee[] employees = new Employee[n];

        // Input employee details
        for (int i = 0; i < n; i++) {
            employees[i] = new Employee(); // create object for each employee

            System.out.println("\nEnter details for Employee " + (i + 1) + ":");
            System.out.print("Enter ID: ");
            employees[i].setEmpID(sc.nextInt());

            sc.nextLine(); // consume leftover newline
            System.out.print("Enter Name: ");
            employees[i].setEmpName(sc.nextLine());

            System.out.print("Enter Salary: ");
            employees[i].setSalary(sc.nextDouble());
        }

        // Print all employee details
        System.out.println("\n===== Employee Details =====");
        for (Employee emp : employees) {
            emp.displayEmployeeDetails();
        }

        sc.close();
    }
}
