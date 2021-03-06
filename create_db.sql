DROP DATABASE IF EXISTS assignment_db;
CREATE DATABASE assignment_db;
USE assignment_db;

create table offices(
	office_id int not null auto_increment,
	office_name varchar(50) not null,
    adress varchar (50) not null,
    primary key (office_id)
 );
 
 create table employees(
	employee_id int not null auto_increment,
	first_name varchar(50) not null,
    last_name varchar(50) not null,
    email varchar(50) not null,
    adress varchar(50) not null,
    employee_comment varchar(50) default null,
    office_id int not null,
    primary key(employee_id)
    );
    
    create table customers(
    customer_id int not null auto_increment,
	first_name varchar(50) not null,
    last_name varchar(50) not null,
    email varchar(50) not null,
    adress varchar(50) not null,
    customer_comment varchar(50) default null,
    organisation_id int default null,
    discount_group int default null,
    primary key(customer_id)
    );
    
    create table products(
    product_id int not null auto_increment,
    product_name varchar(50) not null,
    product_description varchar (50) not null,
    product_price decimal(20,3) not null,
    stock_amount int default null,
    warehouse_id varchar(10) default null,
    primary key(product_id)
    );
    
    create table warehouse(
    warehouse_id int not null auto_increment,
    warehouse_name varchar(50) not null,
    adress varchar(50) not null,
    primary key(warehouse_id)
    );
    
    create table inventory(
    inventory_id int not null auto_increment,
    warehouse_id int not null,
    product_id int not null,
    stock int not null,
    warehouse_position varchar(50) not null,
    primary key(inventory_id)
    );
    
    create table orders(
    order_id int not null auto_increment,
    product_id int not null,
    customer_id int not null,
    amount int not null,
    order_date Date not null,
    requested_shipping_date date default null,
    shipping_date date default null,
    primary key(order_id)
    );
    
    create table reclaims(
    reclaim_id int not null auto_increment,
    product_id int not null,
    assigned_employee_id int default null,
    reclaim_date date not null,
    reclaim_reason varchar(255) default null,
    primary key(reclaim_id)
    );
    
    
 
