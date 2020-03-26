package com.epam.university.service;

import com.epam.university.dao.GroupRepository;
import com.epam.university.dao.MarkRepository;
import com.epam.university.dao.StudentRepository;
import com.epam.university.domain.Faculty;
import com.epam.university.domain.Group;
import com.epam.university.domain.Mark;
import com.epam.university.domain.Student;
import com.epam.university.exceptions.EmptyFacultyException;
import com.epam.university.exceptions.EmptyGroupException;
import com.epam.university.exceptions.InvalidMarkException;
import com.epam.university.exceptions.SubjectException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ValidationHelper {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private GroupRepository groupRepository;
    private StudentRepository studentRepository;
    private MarkRepository markRepository;

    public ValidationHelper(GroupRepository groupRepository, StudentRepository studentRepository, MarkRepository markRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
        this.markRepository = markRepository;
    }

    public void verifyFacultyGroupsPresent(Faculty faculty) {
        logger.info("verify  presence of groups at the faculty '{}'", faculty);
        List<Group> listOfGroups = groupRepository.findAllByFacultyId(faculty.getFacultyId());
        if (listOfGroups.isEmpty()) {
            throw new EmptyFacultyException("Faculty must have at least one group");
        }
    }

    public void verifyGroupStudentsPresent(Group group) {
        logger.info("verify  presence of students in group '{}'", group);
        List<Student> listOfStudents = studentRepository.findAllByGroupId(group.getGroupId());
        if (listOfStudents.isEmpty()) {
            throw new EmptyGroupException("Group must have at least one student");
        }
    }

    public void verifyStudentSubjectsPresent(Student student) {
        logger.info("verify  presence of subjects for student '{}'", student);
        List<Integer> listOfSubjectId = new ArrayList<>();
        List<Mark> list = markRepository.findAllByStudentId(student.getStudentId());
        for (Mark value : list) {
            listOfSubjectId.add(value.getSubjectId());
        }
        if (listOfSubjectId.isEmpty()) {
            throw new SubjectException("Student must have at least one subject");
        }
    }

    public void verifyValidMark(Mark mark) {
        logger.info("validation of marks '{}'", mark);
        if (mark.getMarkId() > 10 || mark.getMarkId() < 0) {
            throw new InvalidMarkException("Invalid mark");
        }
    }
}
