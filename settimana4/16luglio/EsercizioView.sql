-- usa database world
USE world;

-- crea view prendendo name e population da city e join con country per le città con code ITA
CREATE VIEW città_italiane AS
SELECT city.Name , city.Population
FROM city
JOIN country ON city.CountryCode = country.Code
WHERE country.Code = 'ITA';
-- mostra città italiane con popolazione minore di 100000
SELECT Name
FROM città_italiane
WHERE Population < 100000;
-- cancella view
DROP VIEW città_italiane;