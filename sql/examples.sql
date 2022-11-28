SELECT id, name, surname, email FROM student;

SELECT id, name, surname, email FROM student WHERE id = 10;

SELECT id, name, surname, email FROM student WHERE name = 'Maks' OR email = 'ithmaxdob2@ithille.com';

UPDATE student SET email = '???@ithille.com', name = '???' WHERE id = 2;

DELETE FROM student WHERE id = 2;