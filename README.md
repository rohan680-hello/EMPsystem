# Employee Management System (EMP System)

A comprehensive Java-based desktop application designed to streamline the management of employee records. This system provides a user-friendly Graphical User Interface (GUI) to perform essential administrative tasks such as adding, viewing, updating, and removing employee data.

🚀 Features
Secure Authentication: Admin login system to prevent unauthorized access.

Splash Screen: Professional loading interface upon application startup.

Employee Management (CRUD):

Add Employee: Form interface to register new employees with personal and professional details.

View Employees: distinct table view to list all employee records (using rs2xml for data binding).

Update Employee: Search and modify existing employee details.

Remove Employee: Delete records of former employees from the database.

Database Connectivity: Robust connection to MySQL database using JDBC.

🛠️ Technology Stack
Language: Java (JDK 8+)

GUI Framework: Java Swing (AWT/Swing components)

Database: MySQL

IDE: IntelliJ IDEA

Build/Configuration: .iml (IntelliJ Module)

📦 External Libraries / Dependencies
Based on the project configuration:

mysql-connector-java-8.0.28 (JDBC Driver)

jcalendar-tz-1.3.3.4 (Date Picker component)

rs2xml (Utils to populate JTable from Database ResultSets)

EMP System/
├── src/
│   ├── Main_class.java       # Entry point / Main menu
│   ├── Splash.java           # Application loading screen
│   ├── Login.java            # Admin authentication
│   ├── conn.java             # Database connection handling
│   ├── AddEmployee.java      # Module to insert data
│   ├── View_Employee.java    # Module to retrieve and list data
│   ├── UpdateEmployee.java   # Module to modify records
│   └── RemoveEmployee.java   # Module to delete records
└── lib/                      # External JAR files (JCalendar, MySQL Connector, etc.)

⚙️ Setup & Installation
Prerequisites:

Install Java Development Kit (JDK).

Install MySQL Server.

An IDE like IntelliJ IDEA or Eclipse.

Database Configuration: Open your MySQL Client (Workbench/Command Line) and execute the following queries:

CREATE DATABASE employeemanagement;
USE employeemanagement;

CREATE TABLE employee (
    empId VARCHAR(20),
    name VARCHAR(50),
    fname VARCHAR(50),
    age VARCHAR(10),
    dob VARCHAR(20),
    address VARCHAR(100),
    phone VARCHAR(15),
    email VARCHAR(50),
    education VARCHAR(20),
    designation VARCHAR(30),
    aadhar VARCHAR(20),
    salary VARCHAR(20)
);
