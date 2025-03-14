INSERT INTO clients (clientId, name, surname, phone, email, points, createdAt) VALUES
('CL001', 'John', 'Doe', '123-456-7890', 'john.doe@example.com', 0, 1633036800),
('CL002', 'Jane', 'Doe', '098-765-4321', 'jane.doe@example.com', 0, 1633036800),
('CL003', 'Alice', 'Smith', '555-555-5555', 'alice.smith@example.com', 0, 1633036800),
('CL004', 'Bob', 'Johnson', '444-444-4444', 'bob.johnson@example.com', 0, 1633036800),
('CL005', 'Charlie', 'Brown', '333-333-3333', 'charlie.brown@example.com', 0, 1633036800),
('CL006', 'David', 'Wilson', '222-222-2222', 'david.wilson@example.com', 0, 1633036800),
('CL007', 'Eve', 'Adams', '111-111-1111', 'eve.adams@example.com', 0, 1633036800),
('CL008', 'Frank', 'Moore', '666-666-6666', 'frank.moore@example.com', 0, 1633036800),
('CL009', 'Grace', 'Taylor', '777-777-7777', 'grace.taylor@example.com', 0, 1633036800),
('CL010', 'Hank', 'Anderson', '888-888-8888', 'hank.anderson@example.com', 0, 1633036800),
('CL011', 'Ivy', 'Thomas', '999-999-9999', 'ivy.thomas@example.com', 0, 1633036800),
('CL012', 'Jack', 'Jackson', '000-000-0000', 'jack.jackson@example.com', 0, 1633036800),
('CL013', 'Kate', 'White', '123-123-1234', 'kate.white@example.com', 0, 1633036800),
('CL014', 'Liam', 'Martin', '234-234-2345', 'liam.martin@example.com', 0, 1633036800),
('CL015', 'Mia', 'Lee', '345-345-3456', 'mia.lee@example.com', 0, 1633036800),
('CL016', 'Noah', 'Hall', '456-456-4567', 'noah.hall@example.com', 0, 1633036800),
('CL017', 'Olivia', 'Young', '567-567-5678', 'olivia.young@example.com', 0, 1633036800),
('CL018', 'Paul', 'Hernandez', '678-678-6789', 'paul.hernandez@example.com', 0, 1633036800),
('CL019', 'Quinn', 'King', '789-789-7890', 'quinn.king@example.com', 0, 1633036800),
('CL020', 'Rachel', 'Wright', '890-890-8901', 'rachel.wright@example.com', 0, 1633036800),
('CL021', 'Sam', 'Scott', '901-901-9012', 'sam.scott@example.com', 0, 1633036800),
('CL022', 'Tina', 'Green', '012-012-0123', 'tina.green@example.com', 0, 1633036800),
('CL023', 'Uma', 'Adams', '123-456-7891', 'uma.adams@example.com', 0, 1633036800),
('CL024', 'Vincent', 'Roberts', '234-567-8902', 'vincent.roberts@example.com', 0, 1633036800),
('CL025', 'Wendy', 'Turner', '345-678-9013', 'wendy.turner@example.com', 0, 1633036800);

INSERT INTO products (name, id, quantity, price, createdAt) VALUES
('Laptop', 'P001', 10, 999.99, strftime('%s', 'now')),
('Smartphone', 'P002', 25, 499.99, strftime('%s', 'now')),
('Tablet', 'P003', 15, 299.99, strftime('%s', 'now')),
('Headphones', 'P004', 50, 89.99, strftime('%s', 'now')),
('Smartwatch', 'P005', 30, 199.99, strftime('%s', 'now')),
('Desktop Computer', 'P006', 20, 799.99, strftime('%s', 'now')),
('Wireless Mouse', 'P007', 40, 29.99, strftime('%s', 'now')),
('Keyboard', 'P008', 35, 49.99, strftime('%s', 'now')),
('Monitor', 'P009', 12, 199.99, strftime('%s', 'now')),
('Printer', 'P010', 8, 149.99, strftime('%s', 'now')),
('External Hard Drive', 'P011', 18, 89.99, strftime('%s', 'now')),
('USB Flash Drive', 'P012', 50, 19.99, strftime('%s', 'now')),
('Webcam', 'P013', 22, 59.99, strftime('%s', 'now')),
('Microphone', 'P014', 15, 99.99, strftime('%s', 'now')),
('Graphics Card', 'P015', 5, 499.99, strftime('%s', 'now')),
('Motherboard', 'P016', 10, 149.99, strftime('%s', 'now')),
('RAM 16GB', 'P017', 30, 79.99, strftime('%s', 'now')),
('SSD 1TB', 'P018', 20, 129.99, strftime('%s', 'now')),
('HDD 2TB', 'P019', 15, 69.99, strftime('%s', 'now')),
('Gaming Chair', 'P020', 10, 199.99, strftime('%s', 'now'));

INSERT INTO sales (productId, quantity, clientId, totalAmount, createdAt) VALUES
('P001', 1, 'CL001', 999.99, strftime('%s', 'now')),
('P002', 2, 'CL002', 999.98, strftime('%s', 'now')),
('P003', 1, 'CL003', 299.99, strftime('%s', 'now')),
('P004', 3, 'CL004', 269.97, strftime('%s', 'now')),
('P005', 1, 'CL005', 199.99, strftime('%s', 'now')),
('P006', 1, 'CL006', 799.99, strftime('%s', 'now')),
('P007', 5, 'CL007', 149.95, strftime('%s', 'now')),
('P008', 2, 'CL008', 99.98, strftime('%s', 'now')),
('P009', 1, 'CL009', 199.99, strftime('%s', 'now')),
('P010', 1, 'CL010', 149.99, strftime('%s', 'now')),
('P011', 2, 'CL011', 179.98, strftime('%s', 'now')),
('P012', 10, 'CL012', 199.90, strftime('%s', 'now')),
('P013', 1, 'CL013', 59.99, strftime('%s', 'now')),
('P014', 1, 'CL014', 99.99, strftime('%s', 'now')),
('P015', 1, 'CL015', 499.99, strftime('%s', 'now')),
('P016', 1, 'CL016', 149.99, strftime('%s', 'now')),
('P017', 4, 'CL017', 319.96, strftime('%s', 'now')),
('P018', 2, 'CL018', 259.98, strftime('%s', 'now')),
('P019', 3, 'CL019', 209.97, strftime('%s', 'now')),
('P020', 1, 'CL020', 199.99, strftime('%s', 'now'));

UPDATE clients
SET points = (
    SELECT SUM(totalAmount)
    FROM sales
    WHERE sales.clientId = clients.clientId
)
WHERE clientId IN (SELECT DISTINCT clientId FROM sales);