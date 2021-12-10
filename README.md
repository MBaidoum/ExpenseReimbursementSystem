# ExpenseReimbursementSystem

## Description
The Expense Reimbursement System allows employees to make request for cost accrued to be covered by the company.  They may also review all of their tickets both past and present.
These tickets are then approved or denied by a finance manager.  Managers may look at all tickets ever made and serch for tickets based on employee id.

## Technologies Used
* Java
* JavaScript
* HTML
* CSS
* JDBC
* MySQL
* Javalin
* Maven

## Features
* Login screen to access pages based upon login id
* Employees can make tickets in a with a form
* Employees can see all of their tickets in a table
* Managers can look at all tickets on in a table
* Active tickets can be approved or denied on the table
* Manangers cna search for tickets based on employee id
* Users can log out

## Get Started
Clone the repository
`git clone https://github.com/MBaidoum/Ledger.git`
To access the database you must make changes to hibernate.cfg.xml; the following fields need to be changed to your database, username, and password.
![DB Info](https://user-images.githubusercontent.com/80432107/145627651-822ee6ff-3e8a-4e99-a5e8-e3a6716e00b0.PNG)

In order to populate the database there is a standalone file called InitializeDB.
This file has a number of mehtods which can be used to add data to the database.
Finally, you will need something akin to apache tomcat to run the program.

## Usage
When you run the program, you should reach the login screen
![Landing](https://user-images.githubusercontent.com/80432107/145626040-bc4f7270-5afe-4024-a2e4-f6af4ec2a85b.PNG)

Upon reaching this screen you will need to login with the information you added to the database.

If you entered login information for an employee, you will reach this page and be able to access the rest of the website's functions
![EmpPage](https://user-images.githubusercontent.com/80432107/145628255-9d42cb05-9d38-42fa-a208-d75987581a09.PNG)

Entering manager login info will take you to a similar looking page but with one button fewer.

The view ticket button will take you to a table with all tickets belonging to the user on it while the make request button will take you to a form that will let you make a new ticket.  

The request button for managers will take you to a nearly identical table to the view ticket, but pending tickets will have two buttons by them to approve or deny.
![ManPage](https://user-images.githubusercontent.com/80432107/145629234-402d424e-d796-44a8-899c-c70c7d15af0d.PNG)

Entering a number into the serach bar will return a table with only the tickets of the passed employee.

Press the logout button to log out.
