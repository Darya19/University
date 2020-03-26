DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS mark;
DROP TABLE IF EXISTS subject;
DROP TABLE IF EXISTS "GROUP";
DROP TABLE IF EXISTS faculty;
--
CREATE TABLE student
(
    studentId INT PRIMARY KEY,
    groupId   INT          NOT NULL,
    lastName  VARCHAR(250) NOT NULL,
    firstName VARCHAR(250) DEFAULT NULL
);

CREATE TABLE subject
(
    subjectId   INT AUTO_INCREMENT PRIMARY KEY,
    subjectName VARCHAR(250) NOT NULL
);

CREATE TABLE mark
(
    markId    INT AUTO_INCREMENT PRIMARY KEY,
    studentId INT NOT NULL,
    subjectId INT NOT NULL
);

CREATE TABLE "GROUP"
(
    groupId   INT AUTO_INCREMENT PRIMARY KEY,
    groupName VARCHAR(250) NOT NULL,
    facultyId INT          NOT NULL
);

CREATE TABLE faculty
(
    facultyId   INT AUTO_INCREMENT PRIMARY KEY,
    facultyName VARCHAR(250) NOT NULL
);

INSERT INTO student (studentId, groupId, lastName, firstName)
VALUES (1, 1, 'Aliko', 'Dangote'),
       (2, 1, 'Bill', 'Gates'),
       (3, 2, 'Folrunsho', 'Alakija');

INSERT INTO mark (markId, studentId, subjectId)
VALUES (1, 1, 1),
       (2, 2, 1),
       (3, 2, 1),
       (4, 2, 1),
       (5, 2, 1),
       (6, 2, 1),
       (7, 2, 1),
       (8, 2, 1),
       (9, 2, 1),
       (10, 2, 1),
       (11, 2, 1),
       (12, 3, 1);

INSERT INTO subject (subjectId, subjectName)
VALUES (1, 'English'),
       (2, 'Math'),
       (3, 'Programming');

INSERT INTO "GROUP" (groupId, groupName, facultyId)
VALUES (1, 'English', 1),
       (2, 'Math', 2),
       (3, 'Programming', 3);

INSERT INTO faculty (facultyId, facultyName)
VALUES (1, 'EnglishFaculty'),
       (2, 'MathFaculty'),
       (3, 'ProgrammingFacultu');