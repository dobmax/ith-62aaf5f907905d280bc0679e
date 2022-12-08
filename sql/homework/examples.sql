SELECT id, name FROM country;
SELECT id, name, population FROM city;
SELECT id, name, population FROM city WHERE country_id = 1;
SELECT id, name, population FROM city WHERE population >= 1000000;
-- Assume country_id:1 is the city from Pangea
DELETE FROM city WHERE country_id = 1;
-- Assume mainland_id:1 is the country from Pangea
DELETE FROM country WHERE mainland_id = 2;

-- Assume id:1 is Pangea
UPDATE mainland SET existing = false WHERE id = 2;