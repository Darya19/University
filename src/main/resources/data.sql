DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS mark;
DROP TABLE IF EXISTS subject;
DROP TABLE IF EXISTS "GROUP";
DROP TABLE IF EXISTS faculty;
--
CREATE TABLE faculty
(
    facultyId   INT AUTO_INCREMENT PRIMARY KEY,
    facultyName VARCHAR(250) NOT NULL
);

CREATE TABLE "GROUP"
(
    groupId   INT AUTO_INCREMENT PRIMARY KEY,
    groupName VARCHAR(250) NOT NULL,
    facultyId INT          NOT NULL,
    FOREIGN KEY (facultyId) REFERENCES faculty (facultyId)
);

CREATE TABLE student
(
    studentId INT AUTO_INCREMENT PRIMARY KEY,
    groupId   INT          NOT NULL,
    lastName  VARCHAR(250) NOT NULL,
    firstName VARCHAR(250) DEFAULT NULL,
    FOREIGN KEY (groupId) REFERENCES "GROUP" (groupId)
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
    subjectId INT NOT NULL,
    FOREIGN KEY (subjectId) REFERENCES subject (subjectId),
    FOREIGN KEY (studentId) REFERENCES student (studentId)
);

--------------------------------------------------------------

INSERT INTO faculty (facultyName)
VALUES ('EnglishFaculty'),
       ('MathFaculty'),
       ('ProgrammingFacultu');

INSERT INTO "GROUP" (groupName, facultyId)
VALUES ('English', 1),
       ('Math', 2),
       ('Programming', 3);

INSERT INTO student (groupId, lastName, firstName)
VALUES (1, 'Aliko', 'Dangote'),
       (1, 'Bill', 'Gates'),
       (2, 'Folrunsho', 'Alakija');

INSERT INTO subject (subjectName)
VALUES ('English'),
       ('Math'),
       ('Programming');

INSERT INTO mark (studentId, subjectId)
VALUES (1, 1),
       (2, 1),
       (2, 1),
       (2, 1),
       (2, 1),
       (2, 1),
       (2, 1),
       (2, 1),
       (2, 1),
       (2, 1),
       (2, 1),
       (3, 1);
