SELECT id, name, surname, email
FROM student;

SELECT id, name, surname, email
FROM student
WHERE id = 10;

SELECT id, name, surname, email
FROM student
WHERE name = 'Maks'
   OR email = 'ithmaxdob2@ithille.com';

UPDATE student
SET email = '???@ithille.com',
    name  = '???'
WHERE id = 2;

DELETE
FROM student
WHERE id = 2;

SELECT s.id,
       s.name    first_name,
       s.surname last_name,
       s.email,
       g.id      group_id,
       g.name    group_name
FROM student s
         JOIN student_group sg on s.id = sg.student_id
         JOIN "group" g on g.id = sg.group_id;

-- count(), avg(), max(), min(), sum()
SELECT count(id)
FROM student;
SELECT sum(id)
FROM student;
SELECT avg(id)
FROM student;
SELECT min(id)
FROM student;
SELECT max(id)
FROM student;

SELECT g.id, g.name, count(s.id) student_number
FROM "group" g
         JOIN student_group sg on g.id = sg.group_id
         JOIN student s on s.id = sg.student_id
GROUP BY g.id
ORDER BY g.id;

SELECT g.id, g.name, s.name first_name, s.surname last_name
FROM "group" g
         JOIN student_group sg on g.id = sg.group_id
         JOIN student s on s.id = sg.student_id
ORDER BY g.id DESC;