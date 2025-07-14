-- prova commento
-- SELECT seleziona dati da database
SELECT * FROM world.country;

SELECT Continent
FROM world.country;

-- SELECT DISTINCT come Select ma senza ripetizioni
SELECT DISTINCT Name 
FROM world.country;
-- select count torna quante volte
SELECT COUNT(DISTINCT Name) 
FROM world.country;

-- clausola WHERE per mettere condizione
SELECT * FROM world.country
WHERE Region ='North America';

-- clausola WHERE con valore numerico
SELECT * FROM world.country
WHERE Population=0;

-- clausola WHERE con valore null
SELECT *
FROM world.country
WHERE IndepYear IS NULL;

-- operatore AND

SELECT *
FROM world.country
WHERE Population > 10000 AND LifeExpectancy > 80;

-- operatore OR

SELECT *
FROM world.country
WHERE Population > 10000 OR LifeExpectancy > 80;


-- operatore NOT

SELECT *
FROM world.country
WHERE NOT LifeExpectancy > 80;

-- ORDER BY per ordinare result-set ASC

SELECT Name
FROM world.country
ORDER BY SurfaceArea ASC;

-- ORDER BY per ordinare result-set DESC

SELECT Name, LifeExpectancy
From world.country
ORDER BY SurfaceArea DESC;

-- ordinamento per region ascendente e poi per surface area discendente
SELECT * FROM world.country
ORDER BY Region, SurfaceArea DESC;

SELECT Name, SurfaceArea, Population
FROM world.country
ORDER BY SurfaceArea, Population DESC;

-- GROUP BY raggruppa record con stessi valori

SELECT Region, COUNT(Code)
FROM world.country
GROUP BY Region;

-- esempio con GROUP BY con ORDER BY

SELECT Region, COUNT(Code)
FROM world.country
GROUP BY Region
ORDER BY COUNT(Code) DESC;

-- INSERT INTO per inserire nuovi record in una tabella

-- INSERT INTO world.country (Code)
-- VALUES ('BBB');


-- UPDATE per modificare record esistenti in una tabella
-- UPDATE world.country
-- SET Name = 'AAAAAAbb'
-- WHERE Code = 'AAA';

-- DELETE per eliminare record esistenti in una tabella

-- DELETE FROM world.country
-- WHERE Code = 'BBB';

SELECT * FROM world.country;

