-- esercizio 1
SELECT world.countrylanguage.language, world.countrylanguage.Percentage, world.country.Name
FROM world.country
INNER JOIN world.countrylanguage
 ON world.country.Code = world.countrylanguage.CountryCode; 
 
 -- esercizio 2
SELECT c.Name AS Nazione, cl.Language AS Lingua_Piu_Parlata, cl.Percentage AS Percentuale
FROM world.countrylanguage cl
JOIN world.country c ON cl.CountryCode = c.Code
WHERE cl.Percentage >= ALL (
    SELECT Percentage
    FROM world.countrylanguage
    WHERE CountryCode = cl.CountryCode
)
ORDER BY c.Name;


-- esercizio 3

SELECT Nazione, Lingua, Percentuale
FROM (
    SELECT c.Name AS Nazione, cl.Language AS Lingua, cl.Percentage AS Percentuale
    FROM world.countrylanguage cl
    JOIN world.country c ON cl.CountryCode = c.Code
) AS SubLingue
WHERE Percentuale >= ALL (
    SELECT cl2.Percentage
    FROM world.countrylanguage cl2
    WHERE cl2.CountryCode = (
        SELECT Code FROM world.country WHERE Name = SubLingue.Nazione
    )
)
ORDER BY Nazione;
