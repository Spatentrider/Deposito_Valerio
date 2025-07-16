SELECT city.Name AS Città,city.Population,
  CASE 
    WHEN 'SI' = 'SI' THEN country.Name
    ELSE NULL
  END AS Nazione
FROM world.city
JOIN world.country 
ON city.CountryCode = country.Code
WHERE city.CountryCode = 'ITA'
  AND city.Population >= 50000
ORDER BY 
  CASE 
    WHEN 'DESC' = 'DESC' THEN city.Name
  END DESC;
