SELECT Name, Population
FROM world.country
WHERE Population > 5000
ORDER BY Population;

-- Limit per indicare numero massimo
SELECT Name, Population
FROM world.country
WHERE Population > 5000
ORDER BY Population
LIMIT 10;

-- uso Alias per assegnare nome temporaneo a colonna
SELECT Region AS reg
From world.country AS country;

-- MIN() e MAX()

SELECT MAX(Population) AS massimo
FROM world.country
WHERE LifeExpectancy < 75;

SELECT MIN(Population) AS minimo
FROM world.country
WHERE SurfaceArea > 100000;

-- COUNT(), AVG(), SUM()
-- AVG restituisce media valore numerici
SELECT AVG(Population)
FROM world.country
WHERE Continent = 'North America';
-- SUM restituisce somma valori numerici
SELECT SUM(Population)
FROM world.country
WHERE Continent = 'North America';
-- COUNT restituisce numero di record
SELECT COUNT(Code)
FROM world.country
WHERE LifeExpectancy < 70;

