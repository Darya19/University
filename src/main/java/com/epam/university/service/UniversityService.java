package com.epam.university.service;

import com.epam.university.dao.MarkRepository;
import com.epam.university.dao.StudentRepository;
import com.epam.university.domain.Mark;
import com.epam.university.domain.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class UniversityService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private StudentRepository studentRepository;
    private MarkRepository markRepository;

    public UniversityService(StudentRepository studentRepository, MarkRepository markRepository) {
        this.studentRepository = studentRepository;
        this.markRepository = markRepository;
    }

    public int getAverageMarkByStudentId(Integer studentId) {
        logger.info("Get average mark for student '{}'", studentId);

        List<Mark> listOfMarks = markRepository.findAllByStudentId(studentId);
        long sum = listOfMarks.stream().mapToInt(Mark::getMarkId).sum();

        return Math.toIntExact(sum) / listOfMarks.size();
    }

    public int getAverageMarkBySubjectId(Integer subjectId) {
        logger.info("Get average mark for university '{}'", subjectId);
        List<Mark> listOfMarks = markRepository.findAllBySubjectId(subjectId);
        long sum = listOfMarks.stream().mapToInt(Mark::getMarkId).sum();

        return Math.toIntExact(sum) / listOfMarks.size();
    }

    public int getAverageMarkBySubjectNGroup(Integer groupId, Integer subjectId) {
        logger.info("Get average mark for group '{}'", subjectId);
        List<Student> listOfStudents = studentRepository.findAllByGroupId(groupId);
        List<List<Mark>> listOfMarks = listOfStudents.stream()
                .map(Student::getStudentId)
                .map(markRepository::findAllByStudentId)
                .collect(Collectors.toList());

        IntStream intStream = listOfMarks.stream().flatMap(List::stream).mapToInt(Mark::getMarkId);
        long sum = intStream.sum();
        long count = intStream.count();

        return Math.toIntExact(sum) / Math.toIntExact(count);
    }
}
