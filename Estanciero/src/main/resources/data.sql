INSERT INTO properties (propietario, casilla, precio, chacras, alquiler, provincia, zona, mejora, venta)
SELECT 0, 1, 1000, 0, 85, 'FORMOSA', 'SUR', 1000,500
    WHERE NOT EXISTS (
    SELECT 1 FROM properties WHERE casilla = 1 AND provincia = 'FORMOSA' AND zona = 'SUR'
);

INSERT INTO properties (propietario, casilla, precio, chacras, alquiler, provincia, zona, mejora, venta)
SELECT 0, 2, 1000, 0, 85, 'FORMOSA', 'CENTRO',1140,500
    WHERE NOT EXISTS (
    SELECT 1 FROM properties WHERE casilla = 2 AND provincia = 'FORMOSA' AND zona = 'CENTRO'
);

INSERT INTO properties (propietario, casilla, precio, chacras, alquiler, provincia, zona, mejora, venta)
SELECT 0, 3, 1200, 0, 130, 'FORMOSA', 'NORTE',1280,600
    WHERE NOT EXISTS (
    SELECT 1 FROM properties WHERE casilla = 3 AND provincia = 'FORMOSA' AND zona = 'NORTE'
);

INSERT INTO properties (propietario, casilla, precio, chacras, alquiler, provincia, zona, mejora, venta)
SELECT 0, 5, 2000, 0, 220, 'RIO NEGRO', 'SUR',1420,1000
    WHERE NOT EXISTS (
    SELECT 1 FROM properties WHERE casilla = 5 AND provincia = 'RIO NEGRO' AND zona = 'SUR'
);

INSERT INTO properties (propietario, casilla, precio, chacras, alquiler, provincia, zona, mejora, venta)
SELECT 0, 6, 2200, 0, 260, 'RIO NEGRO', 'NORTE',1560,1100
    WHERE NOT EXISTS (
    SELECT 1 FROM properties WHERE casilla = 6 AND provincia = 'RIO NEGRO' AND zona = 'NORTE'
);

INSERT INTO properties (propietario, casilla, precio, chacras, alquiler, provincia, zona, mejora, venta)
SELECT 0, 8, 3800, 0, 100, 'COMPANIA', 'PETROLERA',1700,1400
    WHERE NOT EXISTS (
    SELECT 1 FROM properties WHERE casilla = 8 AND provincia = 'COMPANIA' AND zona = 'PETROLERA'
);

INSERT INTO properties (propietario, casilla, precio, chacras, alquiler, provincia, zona, mejora, venta)
SELECT 0, 9, 2600, 0, 350, 'SALTA', 'SUR',1840,1300
    WHERE NOT EXISTS (
    SELECT 1 FROM properties WHERE casilla = 9 AND provincia = 'SALTA' AND zona = 'SUR'
);

INSERT INTO properties (propietario, casilla, precio, chacras, alquiler, provincia, zona, mejora, venta)
SELECT 0, 11, 2600, 0, 350, 'SALTA', 'CENTRO',1980,1300
    WHERE NOT EXISTS (
    SELECT 1 FROM properties WHERE casilla = 11 AND provincia = 'SALTA' AND zona = 'CENTRO'
);

INSERT INTO properties (propietario, casilla, precio, chacras, alquiler, provincia, zona, mejora, venta)
SELECT 0, 12, 3600, 0, 500, 'FERROCARRIL', 'BELGRANO',2120,1600
    WHERE NOT EXISTS (
    SELECT 1 FROM properties WHERE casilla = 12 AND provincia = 'FERROCARRIL' AND zona = 'BELGRANO'
);

INSERT INTO properties (propietario, casilla, precio, chacras, alquiler, provincia, zona, mejora, venta)
SELECT 0, 13, 3000, 0, 400, 'SALTA', 'NORTE',2260,1500
    WHERE NOT EXISTS (
    SELECT 1 FROM properties WHERE casilla = 13 AND provincia = 'SALTA' AND zona = 'NORTE'
);

INSERT INTO properties (propietario, casilla, precio, chacras, alquiler, provincia, zona, mejora, venta)
SELECT 0, 16, 3800, 0, 100, 'BODEGA', 'NORTE',2400,1600
    WHERE NOT EXISTS (
    SELECT 1 FROM properties WHERE casilla = 16 AND provincia = 'BODEGA' AND zona = 'NORTE'
);

INSERT INTO properties (propietario, casilla, precio, chacras, alquiler, provincia, zona, mejora, venta)
SELECT 0, 17, 3400, 0, 490, 'MENDOZA', 'SUR',2540,1600
    WHERE NOT EXISTS (
    SELECT 1 FROM properties WHERE casilla = 17 AND provincia = 'MENDOZA' AND zona = 'SUR'
);

INSERT INTO properties (propietario, casilla, precio, chacras, alquiler, provincia, zona, mejora, venta)
SELECT 0, 18, 3600, 0, 500, 'FERROCARRIL', 'S.MARTIN',2680,1800
    WHERE NOT EXISTS (
    SELECT 1 FROM properties WHERE casilla = 18 AND provincia = 'FERROCARRIL' AND zona = 'S.MARTIN'
);


INSERT INTO properties (propietario, casilla, precio, chacras, alquiler, provincia, zona, mejora, venta)
SELECT 0, 19, 3400, 0, 490, 'MENDOZA', 'CENTRO',2820,1700
    WHERE NOT EXISTS (
    SELECT 1 FROM properties WHERE casilla = 19 AND provincia = 'MENDOZA' AND zona = 'CENTRO'
);

INSERT INTO properties (propietario, casilla, precio, chacras, alquiler, provincia, zona, mejora, venta)
SELECT 0, 20, 3800, 0, 530, 'MENDOZA', 'NORTE',2960,1900
    WHERE NOT EXISTS (
    SELECT 1 FROM properties WHERE casilla = 20 AND provincia = 'MENDOZA' AND zona = 'NORTE'
);

INSERT INTO properties (propietario, casilla, precio, chacras, alquiler, provincia, zona, mejora, venta)
SELECT 0, 22, 3600, 0, 500, 'FERROCARRIL', 'B.MITRE',3100,1800
    WHERE NOT EXISTS (
    SELECT 1 FROM properties WHERE casilla = 22 AND provincia = 'FERROCARRIL' AND zona = 'B.MITRE'
);

INSERT INTO properties (propietario, casilla, precio, chacras, alquiler, provincia, zona, mejora, venta)
SELECT 0, 23, 4200, 0, 620, 'SANTA FE', 'SUR',3240,2100
    WHERE NOT EXISTS (
    SELECT 1 FROM properties WHERE casilla = 23 AND provincia = 'SANTA FE' AND zona = 'SUR'
);

INSERT INTO properties (propietario, casilla, precio, chacras, alquiler, provincia, zona, mejora, venta)
SELECT 0, 24, 4200, 0, 620, 'SANTA FE', 'CENTRO',3380,2100
    WHERE NOT EXISTS (
    SELECT 1 FROM properties WHERE casilla = 24 AND provincia = 'SANTA FE' AND zona = 'CENTRO'
);

INSERT INTO properties (propietario, casilla, precio, chacras, alquiler, provincia, zona, mejora, venta)
SELECT 0, 26, 4600, 0, 670, 'SANTA FE', 'NORTE',3520,1600
    WHERE NOT EXISTS (
    SELECT 1 FROM properties WHERE casilla = 26 AND provincia = 'SANTA FE' AND zona = 'NORTE'
);

INSERT INTO properties (propietario, casilla, precio, chacras, alquiler, provincia, zona, mejora, venta)
SELECT 0, 27, 3600, 0, 500, 'FERROCARRIL', 'B.URQUIZA',3660,1600
    WHERE NOT EXISTS (
    SELECT 1 FROM properties WHERE casilla = 27 AND provincia = 'FERROCARRIL' AND zona = 'B.URQUIZA'
);

INSERT INTO properties (propietario, casilla, precio, chacras, alquiler, provincia, zona, mejora, venta)
SELECT 0, 29, 5000, 0, 760, 'TUCUMAN', 'SUR',3800,2500
    WHERE NOT EXISTS (
    SELECT 1 FROM properties WHERE casilla = 29 AND provincia = 'TUCUMAN' AND zona = 'SUR'
);

INSERT INTO properties (propietario, casilla, precio, chacras, alquiler, provincia, zona, mejora, venta)
SELECT 0, 30, 5000, 0, 800, 'TUCUMAN', 'NORTE',3940,2500
    WHERE NOT EXISTS (
    SELECT 1 FROM properties WHERE casilla = 30 AND provincia = 'TUCUMAN' AND zona = 'NORTE'
);

INSERT INTO properties (propietario, casilla, precio, chacras, alquiler, provincia, zona, mejora, venta)
SELECT 0, 31, 3800, 0, 100, 'INGENIO', 'NORTE',4080,2800
    WHERE NOT EXISTS (
    SELECT 1 FROM properties WHERE casilla = 31 AND provincia = 'INGENIO' AND zona = 'NORTE'
);

INSERT INTO properties (propietario, casilla, precio, chacras, alquiler, provincia, zona, mejora, venta)
SELECT 0, 32, 6000, 0, 900, 'CORDOBA', 'SUR',4220,3000
    WHERE NOT EXISTS (
    SELECT 1 FROM properties WHERE casilla = 32 AND provincia = 'CORDOBA' AND zona = 'SUR'
);

INSERT INTO properties (propietario, casilla, precio, chacras, alquiler, provincia, zona, mejora, venta)
SELECT 0, 33, 6000, 0, 900, 'CORDOBA', 'CENTRO',4360,3000
    WHERE NOT EXISTS (
    SELECT 1 FROM properties WHERE casilla = 33 AND provincia = 'CORDOBA' AND zona = 'CENTRO'
);

INSERT INTO properties (propietario, casilla, precio, chacras, alquiler, provincia, zona, mejora, venta)
SELECT 0, 34, 6000, 0, 950, 'CORDOBA', 'NORTE',4500,3000
    WHERE NOT EXISTS (
    SELECT 1 FROM properties WHERE casilla = 34 AND provincia = 'CORDOBA' AND zona = 'NORTE'
);

INSERT INTO properties (propietario, casilla, precio, chacras, alquiler, provincia, zona, mejora, venta)
SELECT 0, 37, 7000, 0, 1000, 'BS.AIRES', 'SUR',4640,3500
    WHERE NOT EXISTS (
    SELECT 1 FROM properties WHERE casilla = 37 AND provincia = 'BS.AIRES' AND zona = 'SUR'
);

INSERT INTO properties (propietario, casilla, precio, chacras, alquiler, provincia, zona, mejora, venta)
SELECT 0, 39, 7000, 0, 1000, 'BS.AIRES', 'CENTRO',4780,3500
    WHERE NOT EXISTS (
    SELECT 1 FROM properties WHERE casilla = 39 AND provincia = 'BS.AIRES' AND zona = 'CENTRO'
);

INSERT INTO properties (propietario, casilla, precio, chacras, alquiler, provincia, zona, mejora, venta)
SELECT 0, 40, 7400, 0, 1040, 'BS.AIRES', 'NORTE',4920,3700
    WHERE NOT EXISTS (
    SELECT 1 FROM properties WHERE casilla = 40 AND provincia = 'BS.AIRES' AND zona = 'NORTE'
);


/* ----------------| CARDS |------------------------- */

/*-----------------| DESTINO |------------------------*/

INSERT INTO cards (descripcion, tipo, accion, valor)
SELECT 'Marche preso directamente', 'destino', 'carcel', 0
    WHERE NOT EXISTS (
    SELECT 1 FROM cards WHERE descripcion = 'Marche preso directamente' AND tipo = 'destino'
);

INSERT INTO cards (descripcion, tipo, accion, valor)
SELECT  'Error en los calculos del banco, cobre $4.000', 'destino', 'suma', 4000
    WHERE NOT EXISTS (
    SELECT 1 FROM cards WHERE descripcion = 'Error en los calculos del banco, cobre $4.000' AND tipo = 'destino'
);

INSERT INTO cards (descripcion, tipo, accion, valor)
SELECT  'Ha obtenido un segundo premio de belleza, cobre $200', 'destino', 'suma', 200
    WHERE NOT EXISTS (
    SELECT 1 FROM cards WHERE descripcion = 'Ha obtenido un segundo premio de belleza, cobre $200' AND tipo = 'destino'
);

INSERT INTO cards (descripcion, tipo, accion, valor)
SELECT  '5% de interes sobre cedulas hipotecarias, cobre $500', 'destino', 'suma', 500
    WHERE NOT EXISTS (
    SELECT 1 FROM cards WHERE descripcion = '5% de interes sobre cedulas hipotecarias, cobre $500' AND tipo = 'destino'
);

INSERT INTO cards (descripcion, tipo, accion, valor)
SELECT  'Hereda $2.000', 'destino', 'suma', 2000
    WHERE NOT EXISTS (
    SELECT 1 FROM cards WHERE descripcion = 'Hereda $2.000' AND tipo = 'destino'
);

INSERT INTO cards (descripcion, tipo, accion, valor)
SELECT  'Ha ganado un concurso agricola, cobre $2.000', 'destino', 'suma', 2000
    WHERE NOT EXISTS (
    SELECT 1 FROM cards WHERE descripcion = 'Ha ganado un concurso agricola, cobre $2.000' AND tipo = 'destino'
);

INSERT INTO cards (descripcion, tipo, accion, valor)
SELECT 'Devolucion de impuestos, cobre $400', 'destino', 'suma', 400
    WHERE NOT EXISTS (
    SELECT 1 FROM cards WHERE descripcion = 'Devolucion de impuestos, cobre $400' AND tipo = 'destino'
);
INSERT INTO cards (descripcion, tipo, accion, valor)
SELECT  'Por venta de acciones cobre $1.000', 'destino', 'suma', 1000
    WHERE NOT EXISTS (
    SELECT 1 FROM cards WHERE descripcion = 'Por venta de acciones cobre $1.000' AND tipo = 'destino'
);

INSERT INTO cards (descripcion, tipo, accion, valor)
SELECT  'Siga hasta la salida', 'destino', 'mover',0
    WHERE NOT EXISTS (
    SELECT 1 FROM cards WHERE descripcion = 'Siga hasta la salida' AND tipo = 'destino'
);

INSERT INTO cards (descripcion, tipo, accion, valor)
SELECT  'Vuelve atras hasta la zona Formosa Sur', 'destino', 'mover',1
    WHERE NOT EXISTS (
    SELECT 1 FROM cards WHERE descripcion = 'Vuelve atras hasta la zona Formosa Sur' AND tipo = 'destino'
);

INSERT INTO cards (descripcion, tipo, accion, valor)
SELECT  'Gastos de farmacia, pague $1.000', 'destino', 'resta',1000
    WHERE NOT EXISTS (
    SELECT 1 FROM cards WHERE descripcion = 'Gastos de farmacia, pague $1.000' AND tipo = 'destino'
);

INSERT INTO cards (descripcion, tipo, accion, valor)
SELECT  'Pague la poliza de seguro de $1.000', 'destino', 'resta',1000
    WHERE NOT EXISTS (
    SELECT 1 FROM cards WHERE descripcion = 'Pague la poliza de seguro de $1.000' AND tipo = 'destino'
);




/*-----------------------| SUERTE |-------------------*/

INSERT INTO cards (descripcion, tipo, accion, valor)
SELECT  'Multa caminera, pague $400', 'suerte', 'resta',400
    WHERE NOT EXISTS (
    SELECT 1 FROM cards WHERE descripcion = 'Multa caminera, pague $400' AND tipo = 'suerte'
);

INSERT INTO cards (descripcion, tipo, accion, valor)
SELECT  'Pague $3.000 por gastos colegiales', 'suerte', 'resta',3000
    WHERE NOT EXISTS (
    SELECT 1 FROM cards WHERE descripcion = 'Pague $3.000 por gastos colegiales' AND tipo = 'suerte'
);

INSERT INTO cards (descripcion, tipo, accion, valor)
SELECT  'Multa por exeso de velocidad, pague $300', 'suerte', 'resta',300
    WHERE NOT EXISTS (
    SELECT 1 FROM cards WHERE descripcion = 'Multa por exeso de velocidad, pague $300' AND tipo = 'suerte'
);

INSERT INTO cards (descripcion, tipo, accion, valor)
SELECT  'Ha ganado la grande, cobre $10.000', 'suerte', 'suma',10000
    WHERE NOT EXISTS (
    SELECT 1 FROM cards WHERE descripcion = 'Ha ganado la grande, cobre $10.000' AND tipo = 'suerte'
);

INSERT INTO cards (descripcion, tipo, accion, valor)
SELECT  'Cobre $1.000 por intereses bancarios', 'suerte', 'suma',1000
    WHERE NOT EXISTS (
    SELECT 1 FROM cards WHERE descripcion = 'Cobre $1.000 por intereses bancarios' AND tipo = 'suerte'
);

INSERT INTO cards (descripcion, tipo, accion, valor)
SELECT  'Gano en las carreras, cobre $3.000', 'suerte', 'suma',3000
    WHERE NOT EXISTS (
    SELECT 1 FROM cards WHERE descripcion = 'Gano en las carreras, cobre $3.000' AND tipo = 'suerte'
);

INSERT INTO cards (descripcion, tipo, accion, valor)
SELECT  'Vuelva 3 pasos atras', 'suerte', 'retrocede',3
    WHERE NOT EXISTS (
    SELECT 1 FROM cards WHERE descripcion = 'Vuelva 3 pasos atras' AND tipo = 'suerte'
);

INSERT INTO cards (descripcion, tipo, accion, valor)
SELECT  'Haga un paseo hasta la bodega, si pasa por la salida cobre $5.000', 'suerte', 'mover',16
    WHERE NOT EXISTS (
    SELECT 1 FROM cards WHERE descripcion = 'Haga un paseo hasta la bodega, si pasa por la salida cobre $5.000' AND tipo = 'suerte'
);

INSERT INTO cards (descripcion, tipo, accion, valor)
SELECT  'Siga hasta la salida', 'suerte', 'mover',0
    WHERE NOT EXISTS (
    SELECT 1 FROM cards WHERE descripcion = 'Siga hasta la salida' AND tipo = 'suerte'
);

INSERT INTO cards (descripcion, tipo, accion, valor)
SELECT  'Siga hasta Buenos Aires, zona Norte', 'suerte', 'mover',40
    WHERE NOT EXISTS (
    SELECT 1 FROM cards WHERE descripcion = 'Siga hasta Buenos Aires, zona Norte' AND tipo = 'suerte'
);

INSERT INTO cards (descripcion, tipo, accion, valor)
SELECT  'Siga hasta Salta, zona Norte.Si pasa por la salida cobre $5.000', 'suerte', 'mover',13
    WHERE NOT EXISTS (
    SELECT 1 FROM cards WHERE descripcion = 'Siga hasta Salta, zona Norte.Si pasa por la salida cobre $5.000' AND tipo = 'suerte'
);

INSERT INTO cards (descripcion, tipo, accion, valor)
SELECT  'Siga hasta Santa Fe, zona Norte.Si pasa por la salida cobre $5.000', 'suerte', 'mover',26
    WHERE NOT EXISTS (
    SELECT 1 FROM cards WHERE descripcion = 'Siga hasta Santa Fe, zona Norte.Si pasa por la salida cobre $5.000' AND tipo = 'suerte'
);

INSERT INTO cards (descripcion, tipo, accion, valor)
SELECT 'Marche preso directamente', 'suerte', 'carcel', 0
    WHERE NOT EXISTS (
    SELECT 1 FROM cards WHERE descripcion = 'Marche preso directamente' AND tipo = 'suerte'
);