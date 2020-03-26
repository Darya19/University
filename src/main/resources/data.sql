DROP TABLE IF EXISTS students;

CREATE TABLE students (
  studentId INT AUTO_INCREMENT  PRIMARY KEY,
  groupId INT NOT NULL,
  lastName VARCHAR(250) NOT NULL,
  firstName VARCHAR(250) DEFAULT NULL
);

INSERT INTO students (studentId, groupId, lastName, firstName) VALUES
  (1, 1, 'Aliko', 'Dangote'),
  (2, 1, 'Bill', 'Gates'),
  (3, 2, 'Folrunsho', 'Alakija');


CREATE TABLE marks (
  markId INT AUTO_INCREMENT  PRIMARY KEY,
  studentId INT NOT NULL,
  subjectId INT NOT NULL
);

INSERT INTO marks (markId, studentId, subjectId) VALUES
  (1, 1, 1),
  (2, 2, 1),
  (3, 3, 1);