-- creazione tabella
CREATE TABLE world.Vendite (
    id INT PRIMARY KEY,
    prodotto VARCHAR(100),
    categoria VARCHAR(50),
    quantita INT,
    prezzo_unitario DECIMAL(6,2),
    data_vendita DATE
);
-- inserimento dati
INSERT INTO world.Vendite (id, prodotto, categoria, quantita, prezzo_unitario, data_vendita) VALUES
(1, 'Laptop Dell XPS', 'Elettronica', 2, 1200.00, '2024-01-10'),
(2, 'iPhone 13', 'Elettronica', 5, 999.99, '2024-01-15'),
(3, 'Samsung TV 55"', 'Elettrodomestici', 1, 699.90, '2024-01-20'),
(4, 'Aspirapolvere Dyson', 'Elettrodomestici', 3, 349.50, '2024-01-22'),
(5, 'Nike Air Max', 'Abbigliamento', 4, 129.99, '2024-02-02'),
(6, 'Jeans Levi\'s 501', 'Abbigliamento', 6, 89.90, '2024-02-05'),
(7, 'Echo Dot', 'Elettronica', 10, 49.99, '2024-02-08'),
(8, 'Caffettiera Bialetti', 'Casa', 8, 34.95, '2024-02-12'),
(9, 'Zaino Eastpak', 'Accessori', 5, 59.00, '2024-02-15'),
(10, 'Libro: Il nome della rosa', 'Libri', 7, 15.50, '2024-02-18'),
(11, 'iPad Air', 'Elettronica', 3, 699.00, '2024-02-20'),
(12, 'Asciugacapelli Philips', 'Elettrodomestici', 2, 44.90, '2024-02-25'),
(13, 'T-shirt Adidas', 'Abbigliamento', 9, 24.99, '2024-03-01'),
(14, 'Tostapane Ariete', 'Casa', 4, 39.99, '2024-03-04'),
(15, 'Smartwatch Fitbit', 'Elettronica', 6, 149.00, '2024-03-06'),
(16, 'Set pentole Lagostina', 'Casa', 1, 199.99, '2024-03-10'),
(17, 'Felpa Champion', 'Abbigliamento', 5, 49.90, '2024-03-15'),
(18, 'Libro: Sapiens', 'Libri', 10, 18.00, '2024-03-20'),
(19, 'Lampada da tavolo LED', 'Casa', 7, 29.90, '2024-03-22'),
(20, 'Cuffie Sony WH-1000XM4', 'Elettronica', 2, 299.90, '2024-03-25');
-- vendite totali per categoria
SELECT categoria, COUNT(*) 
FROM world.vendite
GROUP BY categoria;

-- prezzo medio per categoria
SELECT categoria, AVG(prezzo_unitario)
FROM world.vendite
GROUP BY categoria;
-- quantita totale per prodotto
SELECT prodotto, SUM(quantita)
from world.vendite
GROUP BY prodotto;
-- prezzo minimo di tutti i prodotti
SELECT MIN(prezzo_unitario)
from world.vendite;
-- prezzo massimo di tutti i prodotti
SELECT MAX(prezzo_unitario)
from world.vendite;
-- righe totali
SELECT COUNT(id)
FROM world.vendite;
-- 5 prodotti piu costosi
SELECT prodotto, prezzo_unitario
FROM world.vendite
ORDER BY prezzo_unitario DESC
LIMIT 5;
-- 3 prodotti meno venduti per quantità
SELECT prodotto, SUM(quantita) AS totale
FROM world.vendite
GROUP BY prodotto
ORDER BY totale
LIMIT 3;