INSERT INTO users (first_name, middle_name, last_name, email, phone_number, car_number, car_model)
VALUES ('Carl', 'Fridrich', 'Gauss', 'GaussKF@gmail.com', '7913154847', 'A555AA55', 'BMW X6 White'),
       ('John', 'Paul', 'Doe', 'DoeJP@gmail.com', '79131894411', 'X777AM777', 'Lamborghini Diablo Black'),
       ('Vyacheslav', 'Vladimir', 'Mamontoff', 'Mamontovv.v@gmail.com', '79835247953', 'Y121BA55', 'Toyota Prius White');
COMMIT;

INSERT INTO parking_places (number, status, price)
VALUES ('A01', 'ENABLED', 0.99),
       ('A02', 'ENABLED', 0.96),
       ('A03', 'ENABLED', 0.93),
       ('B01', 'ENABLED', 0.89),
       ('B02', 'ENABLED', 0.86),
       ('B03', 'ENABLED', 0.83),
       ('C01', 'ENABLED', 0.79),
       ('C02', 'ENABLED', 0.76),
       ('C03', 'ENABLED', 0.73);
COMMIT;

INSERT INTO parking_tickets (place_id, user_id, start_time, duration_minutes, prepaid)
VALUES (1, 1, '2022-04-27 16:55:00', 90, TRUE),
       (4, 2, '2022-04-27 17:02:00', 60, TRUE),
       (7, 3, '2022-04-27 17:10:00', 50, FALSE);
COMMIT;
