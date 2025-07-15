-- esercizio 1
SELECT world.city.Name, world.country.Name, world.countrylanguage.Language
FROM world.city
INNER JOIN world.country 
  ON world.city.CountryCode = world.country.Code
INNER JOIN world.countrylanguage 
  ON world.country.Code = world.countrylanguage.CountryCode;


-- esercizio 2