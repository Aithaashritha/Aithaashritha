package com.employee;

import java.util.Scanner;

class Employee {
    private int empID;
    private String empName;
    private double salary;
    private String location;

    // 🔹 Default constructor (sets default values)
    public Employee() {
        empID = 0;
        empName = "Unknown";
        salary = 0.0;
        location = "Not Assigned";
    }

    // 🔹 Parameterized constructor (user-provided values)
    public Employee(int empID, String empName, double salary, String location) {
        this.empID = empID;
        this.empName = empName;
        this.salary = salary;
        this.location = location;
    }

    public void displayEmployeeDetails() {
        System.out.println("ID: " + empID +
                           " | Name: " + empName +
                           " | Salary: ₹" + salary +
                           " | Location: " + location);
    }
}

public class EmployeeDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Do you want to enter employee details manually? (yes/no): ");
        String choice = sc.nextLine();

        Employee emp;

        if (choice.equalsIgnoreCase("yes")) {
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            System.out.print("Enter Location: ");
            String location = sc.nextLine();

            // 🟢 Create object using parameterized constructor
            emp = new Employee(id, name, salary, location);
        } else {
            // 🟢 Create object using default constructor
            emp = new Employee();
        }

        System.out.println("\n===== Employee Details =====");
        emp.displayEmployeeDetails();

        sc.close();
    }
}
