-- Having clausola che opera sui raggruppamenti invece che su campi della tabella
SELECT CountryCode, COUNT(*) AS NumeroLingue
FROM CountryLanguage
WHERE IsOfficial = 'T'
GROUP BY CountryCode
HAVING COUNT(*) > 1;
-- esempio con JOIN
SELECT Country.Name, COUNT(*) AS NumeroLingue
FROM Country
JOIN CountryLanguage ON Country.Code = CountryLanguage.CountryCode
WHERE CountryLanguage.IsOfficial = 'T'
GROUP BY Country.Name
HAVING COUNT(*) > 1;

-- Exist verifica esistenza di record in una sottoquery, booleano

SELECT Name
FROM world.country
WHERE EXISTS
(SELECT Population
FROM world.country
WHERE Population < 10000000);

-- ANY restituisce true se uno dei valori della sottoquery soddisfa condizione operatore

SELECT Name
FROM world.country
WHERE LifeExpectancy > ANY (
  SELECT LifeExpectancy
  FROM world.country
  WHERE Continent = 'Europe'
);

-- ALL TRUE se tutti i valori sottoquery soddisfa condizione operatore
SELECT Name
FROM country
WHERE Population > ALL 
(SELECT Population
FROM city
WHERE Population > 500000);
-- 
SELECT Name, CountryCode, Population
FROM City
WHERE Population > ALL (
SELECT Population
FROM City
WHERE CountryCode = 'ITA'
);


-- Schemi relazionali
-- INSERT INTO con SELECT

INSERT INTO world.city (Name, CountryCode, District, Population)
SELECT 
    country.Name, 
    country.Code,       
    'CapitalInsert',    
    0                   
FROM world.country
WHERE country.Population > 100000000;


-- CASE

SELECT Name,
       Population,
       CASE 
           WHEN Population >= 100000000 THEN 'Molto Popoloso'
           WHEN Population >= 50000000 THEN 'Popoloso'
           WHEN Population >= 10000000 THEN 'Medio'
           ELSE 'Piccolo'
       END AS Categoria_Popolazione
FROM world.country
ORDER BY Population DESC;

-- esempio con NULL

SELECT Name, Capital, Region
FROM world.country
ORDER BY 
  CASE
    WHEN Capital IS NULL THEN Region
    ELSE Capital
  END;

-- IFNULL() restituisce valore alternativo
-- IFNULL(SELECT, valore)

-- COALESCE() funzione porta primo valore non NULL
-- COALESCENCE(val1, val2)

