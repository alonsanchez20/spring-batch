CREATE TABLE IF NOT EXISTS transaccion
(
    id    LONG    PRIMARY    KEY,
    fecha    TIMESTAMP    NOT    NULL,
    tipo    VARCHAR(    255) NOT NULL,
    importe DECIMAL(    10,    2) NOT NULL,
    reviewed BOOLEAN NOT NULL
);


/*
INSERT INTO transaccion (id, fecha, tipo, importe)
VALUES ('1234567900', '2024-02-03 09:15:00', 'DEPOSITO', 700.00),
       ('1234567901', '2024-02-01 13:45:00', 'RETIRO', 150.00),
       ('1234567902', '2024-01-29 17:30:00', 'TRANSFERENCIA', 400.00),
       ('1234567903', '2024-01-26 11:00:00', 'PAGO_SERVICIO', 200.00),
       ('1234567904', '2024-01-22 15:20:00', 'DEPOSITO', 600.00),
       ('1234567905', '2024-01-20 18:45:00', 'RETIRO', 75.00),
       ('1234567906', '2024-01-17 12:00:00', 'TRANSFERENCIA', 300.00),
       ('1234567907', '2024-01-15 16:30:00', 'PAGO_SERVICIO', 100.00),
       ('1234567908', '2024-01-12 20:10:00', 'DEPOSITO', 800.00),
       ('1234567909', '2024-01-10 09:25:00', 'RETIRO', 125.00),
       ('1234567910', '2024-01-07 14:55:00', 'TRANSFERENCIA', 350.00),
       ('1234567911', '2024-01-05 18:40:00', 'PAGO_SERVICIO', 150.00),
       ('1234567912', '2024-01-02 22:20:00', 'DEPOSITO', 900.00),
       ('1234567913', '2023-12-31 10:35:00', 'RETIRO', 100.00),
       ('1234567914', '2023-12-28 15:05:00', 'TRANSFERENCIA', 450.00),
       ('1234567915', '2023-12-26 18:50:00', 'PAGO_SERVICIO', 125.00),
       ('1234567916', '2023-12-23 22:30:00', 'DEPOSITO', 1000.00),
       ('1234567917', '2023-12-21 09:55:00', 'RETIRO', 200.00),
       ('1234567918', '2023-12-18 14:25:00', 'TRANSFERENCIA', 500.00),
       ('1234567919', '2023-12-15 18:10:00', 'PAGO_SERVICIO', 150.00),
       ('1234567920', '2023-12-12 21:50:00', 'DEPOSITO', 300.00),
       ('1234567921', '2023-12-10 10:15:00', 'RETIRO', 100.00),
       ('1234567922', '2023-12-07 14:45:00', 'TRANSFERENCIA', 250.00),
       ('1234567923', '2023-12-05 18:30:00', 'PAGO_SERVICIO', 75.00),
       ('1234567924', '2023-12-02 22:10:00', 'DEPOSITO', 400.00),
       ('1234567925', '2023-11-30 09:35:00', 'RETIRO', 50.00),
       ('1234567926', '2023-11-27 14:05:00', 'TRANSFERENCIA', 200.00),
       ('1234567927', '2023-11-25 17:50:00', 'PAGO_SERVICIO', 100.00),
       ('1234567928', '2023-11-22 21:30:00', 'DEPOSITO', 500.00),
       ('1234567929', '2023-11-20 08:55:00', 'RETIRO', 75.00),
       ('1234567930', '2023-11-17 13:25:00', 'TRANSFERENCIA', 300.00),
       ('1234567931', '2023-11-15 17:10:00', 'PAGO_SERVICIO', 125.00),
       ('1234567932', '2023-11-12 20:50:00', 'DEPOSITO', 600.00),
       ('1234567933', '2023-11-10 10:15:00', 'RETIRO', 150.00),
       ('1234567934', '2023-11-07 14:45:00', 'TRANSFERENCIA', 350.00),
       ('1234567935', '2023-11-05 18:30:00', 'PAGO_SERVICIO', 150.00),
       ('1234567936', '2023-11-02 22:10:00', 'DEPOSITO', 700.00),
       ('1234567937', '2023-10-31 09:35:00', 'RETIRO', 100.00),
       ('1234567938', '2023-10-28 14:05:00', 'TRANSFERENCIA', 400.00),
       ('1234567939', '2023-10-26 17:50:00', 'PAGO_SERVICIO', 200.00),
       ('1234567940', '2023-10-23 21:30:00', 'DEPOSITO', 800.00);



 */