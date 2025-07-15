-- creazione tabella
CREATE TABLE world.Libri (
    id INT PRIMARY KEY,
    titolo VARCHAR(100),
    autore VARCHAR(100),
    genere VARCHAR(50),
    prezzo DECIMAL(5,2),
    anno_pubblicazione INT
);

-- inserimento libri
INSERT INTO world.Libri (id, titolo, autore, genere, prezzo, anno_pubblicazione)
VALUES
(1, 'Il nome della rosa', 'Umberto Eco', 'Storico', 14.90, 1980),
(2, 'La solitudine dei numeri primi', 'Paolo Giordano', 'Narrativa', 12.50, 2008),
(3, 'Sapiens', 'Yuval Noah Harari', 'Saggistica', 18.00, 2014),
(4, 'Educated', 'Tara Westover', 'Autobiografia', 16.20, 2018),
(5, '1984', 'George Orwell', 'Distopico', 10.99, 1949),
(6, 'Il cacciatore di aquiloni', 'Khaled Hosseini', 'Narrativa', 13.75, 2003);

-- numero totale libri e prezzo medio
SELECT genere, COUNT(id), AVG(prezzo)
FROM world.Libri
GROUP BY genere
ORDER BY genere;


-- ordinamento libri pubblicati dopo 2010 e per prezzo
SELECT titolo, anno_pubblicazione, prezzo
FROM world.Libri
WHERE anno_pubblicazione > 2010
ORDER BY anno_pubblicazione DESC, prezzo ASC;
