INSERT INTO student (name, surname, email)
VALUES ('StudName1', 'StudName1', 'ithstud1@ithille.com'),
       ('StudName2', 'StudName2', 'ithstud2@ithille.com'),
       ('StudName3', 'StudName3', 'ithstud3@ithille.com'),
       ('StudName4', 'StudName4', 'ithstud4@ithille.com'),
       ('StudName5', 'StudName5', 'ithstud5@ithille.com');

INSERT INTO "group" (name)
VALUES ('ith1'),
       ('ith2');

INSERT INTO student_group (student_id, group_id)
VALUES (1, 1),
       (2, 1),
       (3, 2),
       (4, 2);

-- ACID - transaction principle
-- Atomicity
-- Consistency
-- Isolation
-- Durability

INSERT INTO student (name, surname, email)
VALUES ('StudNameX', 'StudNameX', 'ithstudX@ithille.com');
ROLLBACK;

INSERT INTO student (name, surname, email)
VALUES ('StudNameN', 'StudNameN', 'ithstudN@ithille.com');
COMMIT;