-- crea tabella clienti2
CREATE TABLE world.Clienti2 (
    id INT PRIMARY KEY,
    nome VARCHAR(100),
    città VARCHAR(100)
);
-- crea tabella ordini
CREATE TABLE world.Ordini (
    id INT PRIMARY KEY,
    id_cliente INT,
    data_ordine DATE,
    importo DECIMAL(7,2)
);
-- inserimento dati clienti 2
INSERT INTO world.Clienti2 (id, nome, città) VALUES
(1, 'Marco Rossi', 'Milano'),
(2, 'Giulia Bianchi', 'Roma'),
(3, 'Luca Verdi', 'Torino'),
(4, 'Elena Russo', 'Napoli'),
(5, 'Paolo Ferrari', 'Bologna'),
(6, 'Anna Esposito', 'Firenze'),
(7, 'Davide Conti', 'Genova'),
(8, 'Sara Marino', 'Verona'),
(9, 'Francesco Lombardi', 'Bari'),
(10, 'Chiara Fontana', 'Catania'),
(11, 'Alessandro Galli', 'Padova'),
(12, 'Laura Moretti', 'Palermo'),
(13, 'Simone Rizzo', 'Trieste'),
(14, 'Marta Greco', 'Parma'),
(15, 'Giorgio De Luca', 'Reggio Emilia'),
(16, 'Ilaria Monti', 'Perugia'),
(17, 'Matteo Bruno', 'Livorno'),
(18, 'Beatrice Vitale', 'Trento'),
(19, 'Stefano Caruso', 'Ancona'),
(20, 'Valentina Barbieri', 'Lecce');

-- inserimento dati ordini
INSERT INTO world.Ordini (id, id_cliente, data_ordine, importo) VALUES
(1, 1, '2024-01-10', 250.00),
(2, 3, '2024-01-15', 100.50),
(3, 2, '2024-01-20', 75.20),
(4, 1, '2024-02-05', 300.00),
(5, 5, '2024-02-10', 150.75),
(6, 7, '2024-02-15', 200.00),
(7, 8, '2024-02-20', 125.00),
(8, 4, '2024-02-25', 180.50),
(9, 10, '2024-03-01', 220.00),
(10, 11, '2024-03-05', 130.00),
(11, 12, '2024-03-10', 90.00),
(12, 6, '2024-03-15', 160.00),
(13, 13, '2024-03-20', 210.00),
(14, 14, '2024-03-25', 195.00),
(15, 15, '2024-03-30', 175.00),
(16, 16, '2024-04-05', 80.00),
(17, 17, '2024-04-10', 300.00),
(18, 18, '2024-04-15', 120.00),
(19, 19, '2024-04-20', 140.00),
(20, 20, '2024-04-25', 160.00);

-- mostra clienti che hanno fatto almeno un ordine comparando id clienti con id ordini con INNER JOIN
SELECT clienti2.nome, ordini.data_ordine, ordini.importo
FROM world.Clienti2 
INNER JOIN world.Ordini 
  ON clienti2.id = ordini.id_cliente;

-- mostra tutti clienti anche quelli che non hanno fatto ordini comparando id clienti con id ordini con LEFT JOIN
SELECT clienti2.nome, ordini.data_ordine, ordini.importo
FROM world.Clienti2
LEFT JOIN world.Ordini 
  ON clienti2.id = ordini.id_cliente;

-- mostra tutti ordini anche se non hanno un cliente comparando id clienti con id ordini con RIGHT JOIN
SELECT clienti2.nome, ordini.data_ordine, ordini.importo
FROM world.Clienti2
RIGHT JOIN world.Ordini 
  ON clienti2.id = ordini.id_cliente;
-- clienti con almeno un ordine con Count degli ordini e somma totale dell'importo
SELECT clienti2.nome, COUNT(ordini.id), SUM(ordini.importo)
FROM world.Clienti2
INNER JOIN world.Ordini
 ON clienti2.id = ordini.id_cliente
GROUP BY clienti2.id, clienti2.nome;
-- clienti senza ordini con nome e città 
SELECT clienti2.nome, clienti2.città
FROM world.Clienti2
LEFT JOIN world.Ordini
 ON clienti2.id = ordini.id_cliente
WHERE ordini.id IS NULL;
-- ordini senza clienti 
SELECT ordini.id, ordini.data_ordine, ordini.importo
FROM world.Clienti2
RIGHT JOIN world.Ordini
 ON clienti2.id = ordini.id_cliente
WHERE Clienti2.id IS NULL;