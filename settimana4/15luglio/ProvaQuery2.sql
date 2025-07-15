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


-- wildcard Characters

-- like cerca pattern usando metacaratteri
SELECT name, Population
FROM world.country
WHERE name LIKE 'a%';

-- in specifica piu valori in una clausola, ina scorciatoia per piu condizioni OR

SELECT Name
FROM world.country
WHERE Region IN ('Western Europe', 'Africa');

SELECT * FROM world.country
WHERE Name IN ('Germany', 'France');

-- between seleziona valori all'interno di un intervallo

SELECT Name, Population
FROM world.country
WHERE Population BETWEEN 500000 AND 2000000
GROUP BY Region
ORDER BY Population;

SELECT Name
FROM world.country
WHERE NAME NOT BETWEEN 'F%' AND 'M%'
ORDER BY Name;

-- JOIN 
-- INNER JOIN solo elementi comuni

SELECT city.Name AS Città, city.Population AS Popolazione, country.Name AS Paese
FROM world.city
INNER JOIN world.country
  ON city.CountryCode = country.Code;



-- LEFT OUTER tutti tabella sinistra e quelli in comune

SELECT City.Name AS CityName, Country.Name AS CountryName
FROM City
LEFT JOIN Country ON City.CountryCode = Country.Code;
-- RIGHT OUTER tutti tabella destra e quelli in comune
SELECT City.Name AS CityName, Country.Name AS CountryName
FROM City
LEFT JOIN Country ON City.CountryCode = Country.Code;
-- FULL OUTER JOIN se c'è almeno una corrispondenza restituisce tutti i record di tutte le tabelle
SELECT city.Name, country.Region
FROM world.city
CROSS JOIN world.country;

-- UNION
SELECT Population From world.country
UNION
SELECT Population from world.city;

SELECT City.Name AS CityName, Country.Name AS CountryName
FROM City
LEFT JOIN Country ON City.CountryCode = Country.Code
UNION 
SELECT City.Name AS CityName, Country.Name AS CountryName
FROM City
RIGHT JOIN Country ON City.CountryCode = Country.Code;

-- UNION ALL
SELECT Population AS Newpopulation From world.country
UNION
SELECT Population from world.city;

SELECT world.city.Name, world.country.Name, world.countrylanguage.Language
FROM world.city
JOIN world.country ON world.city.CountryCode = world.country.Code
JOIN world.countrylanguage ON world.country.Code = world.countrylanguage.CountryCode

UNION

SELECT  world.city.Name, world.country.Name, world.countrylanguage.Language
FROM world.countrylanguage
JOIN world.country ON world.countrylanguage.CountryCode = world.country.Code
JOIN world.city ON world.city.CountryCode = world.country.Code;


