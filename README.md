Invoice Management System

Main objective of this project is managing Invoices. Developed all types of CRUD operations.

Technologies used: Java, Springboot, REST, Hibernate, JPA and MySQL.

How to access:
Base URL: http://localhost:8080
APIs:
1. Create Invoice
    URL: /invoices/create
    Method:Post
    Payload: {"amount": 700.0,"due_date": "2024-11-27","late_fee":0.00}
2. Fetch Invoices
    URL: /invoices/view
    Method:Get
3. Pay invoice
    URL: /invoices/payments/10
    Method:Put
    Payload: {"amount": 1000.0,"due_date": "2024-11-27","late_fee":0.00}
4. Process overdue invoices
    URL: /invoices/process-overdue
    Method:Post
    Payload: {}

DB design:

Table : invoice_details

Schema:

CREATE TABLE `invoice_details` (
`id` INT NOT NULL AUTO_INCREMENT ,
`amount` DOUBLE(16,2) DEFAULT 0.00 ,
`due_date` DATETIME ,
`late_fee` DOUBLE(16,2) DEFAULT 0.00 ,
`overdue_days` INT DEFAULT 0,
`paid_amount` DOUBLE(16,2) DEFAULT 0.00 ,
`status` ENUM('PENDING', 'PAID', 'VOID') ,
PRIMARY KEY (`id`));
 
 
 
