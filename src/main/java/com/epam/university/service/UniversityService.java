package com.epam.university.service;

import com.epam.university.domain.Student;

public interface UniversityService {

    int getAverageMarkByStudentId(Integer studentId);

    int getAverageMarkBySubjectId(Integer subjectId);

    int getAverageMarkBySubjectNGroup(Integer groupId, Integer subjectId);

    void save(int id, int groupId, String name, String lastName);

    Student getById(int id);

    Iterable<Student> findAll();
}
