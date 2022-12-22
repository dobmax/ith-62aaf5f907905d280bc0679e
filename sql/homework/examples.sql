SELECT c.id, c.name, c.population, ctr.id as coutry_id, ctr.name as coutry_name FROM city
JOIN country ctr ON c.country_id = ctr.id;

SELECT id, name, population FROM city WHERE id = 1;

SELECT id, name, SUM(c.population) as population FROM country
JOIN city c ON country.id = c.id
WHERE id = 1
GROUP BY c.id;

SELECT id, name, AVG(c.population) as population FROM country
JOIN city c ON country.id = c.id
GROUP BY c.id;

BEGIN;
UPDATE city SET population = 99999 WHERE id = 1;
COMMIT;

BEGIN;
DELETE FROM city WHERE id IN (1, 2, 3)
COMMIT;