use assignment_db;

insert into customers(first_name, last_name, email, address, customer_comment, organisation_id, discount_group) values
('Bob', 'Bobsberg', 'bob@bob.com', 'bobstreet 5', 'good', '5', '2'),
('Anna', 'Annington', 'Anna@anna.com', 'clearview 2', '', '3', '3'),
('Trey', 'Irving', 'trey@bob.com', 'boulevard 14', 'meh', '1', '1'),
('Ophelia', 'King', 'bob@bob.com', 'bobstreet 7', 'good', '5', '2'),
('Cherry', 'Bobsberg', 'Cherry@bob.com', 'underthebridge 3', 'outstanding', '5', '3');

insert into employees(first_name, last_name, email, address, employee_comment, office_id) values
('Chester', 'Bloomer', 'Chester@company.com', 'chesterstreet 5', '', '1'),
('Tiago', 'Rivera', 'Tiago@company.com', 'Tiagostreet 5', '', '1'),
('Lillia', 'Mieta', 'Lillia@company.com', 'Lilliastreet 5', '', '1'),
('Johhny', 'Cash', 'Johhny@company.com', 'chesterstreet 2', '', '2'),
('Rico', 'Shaw', 'Rico@company.com', 'ricorstreet 2', '', '2');

insert into offices(office_name, address) values
('Dunder mifflin', "Scranton"),
('Monsters inc', 'Monstertown');

insert into products(product_name, product_description, product_price, stock_amount, warehouse_id) values
('Apple', 'fruit', '2.5', '100', '1,2,3'),
('Banana', 'fruit', '5', '150', '1,2'),
('Carrot', 'vegetable', '3', '50', '1'),
('Cucumber', 'vegetable', '10', '50', '1,3'),
('Mango', 'fruit', '3', '200', '3');

insert into warehouse(warehouse_name, address) values
('Scranton', 'Scranton 1'),
('Monsterstorage', 'Roarroad 3'),
('Secret storage', 'area 51');

insert into inventory(warehouse_id, product_id, stock, warehouse_position) values
('1', '1', '33', 'A1'),
('2', '1', '33', 'A1'),
('3', '1', '34', 'A1'),

('1', '2', '75', 'B1'),
('2', '2', '75', 'B1'),

('1', '3', '50', 'C1'),

('1', '3', '25', 'D1'),
('3', '3', '25', 'D1'),

('3', '5', '200', 'E1');

insert into orders(product_id, customer_id, amount, order_date, requested_shipping_date, shipping_date) values
('1', '1', '5', '2020-01-01', '2020-01-05', '2020-01-05'),
('2', '2', '10', '2020-01-01', '2020-01-05', '2020-01-05'),
('3', '3', '15', '2020-01-01', '2020-01-05', '2020-01-05'),
('4', '4', '20', '2020-01-01', '2020-01-05', '2020-01-05'),
('5', '5', '25', '2020-01-01', '2020-01-05', '2020-01-05');

insert into reclaims(product_id, assigned_employee_id, reclaim_date, reclaim_reason) values
('1', '1', '2020-02-01', 'wrong color');








