INSERT INTO address (address_line1, address_line2, city, postal_code) VALUES
('Grove Street', 'Apt 1', 'Los Santos', '62-030'),
('Autostrada Julius', NULL, ' Las Venturas', '54321'),
('Windy, Windy, Windy, Apt 69', 'Suite 200', 'San Fierro', '67890'),
('Santa Maria Drive', NULL, 'Los Santos', '23456'),
('San Peeso Street', 'Apt 3', ' Las Venturas', '65432'),
('Main Street', NULL, 'Fort Carson', '78901');

INSERT INTO doctor (doctor_number, email, first_name, last_name, specialization, telephone_number, address_id) VALUES 
('D123', 'Carl.Johnson@example.com', 'Carl', 'Johnson', 'SURGEON', '123-456-7890', 1),
('D124', 'Big.Smoke@example.com', 'Melvin ', 'Harris', 'DERMATOLOGIST', '234-567-8901', 2),
('D126', 'Ryder@example.com', 'Lance', 'Wilson', 'OCULIST', '456-789-0123', 3);

INSERT INTO medical_treatment (description, type) VALUES 
('Physical therapy', 'USG'),
('Chemotherapy', 'EKG'),
('MRI Scan', 'USG'),
('Dialysis', 'RTG');

INSERT INTO patient (date_of_birth, email, first_name, last_name, patient_number, telephone_number, address_id, age) VALUES
('1980-01-01', 'Cesar.Vilpando@example.com', 'Cesar', 'Vilpando', 'P123', '345-678-9012', 4, 44),
('1990-02-02', 'Kendl.Johnson@example.com', 'Kendl', 'Johnson', 'P124', '456-789-0123', 5, 34),
('1975-03-03', 'OG.Loc@example.com', 'Jefferey', 'Martin', 'P125', '567-890-1234', 6, 49);

INSERT INTO visit (description, time, doctor_id, patient_id) VALUES
('Regular check-up', '2024-05-24 09:00:00', 1, 2),
('Follow-up visit', '2024-05-25 10:00:00', 3, 2),
('Annual physical exam', '2024-05-26 11:00:00', 3, 3),
('Treatment review', '2024-05-27 13:00:00', 2, 1);

INSERT INTO visit_treatment (visit_id, treatment_id) VALUES 
(1, 1),
(2, 2),
(3, 3),
(4, 1);
