package com.epam.university.controller;

import com.epam.university.domain.Student;
import com.epam.university.service.UniversityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;

@RestController
@RequestMapping(value = "/api")
public class UniversityController extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    protected int getAverageMarkByStudentId(@RequestParam int studentId) {
        logger.debug("Get average mark for student by id '{}'", studentId);
        return universityService.getAverageMarkByStudentId(studentId);
    }

    @RequestMapping(value = "/subject", method = RequestMethod.GET)
    protected int getAverageMarkBySubjectId(@RequestParam int subjectId) {
        logger.debug("Get average mark for subject by id '{}'", subjectId);
        return universityService.getAverageMarkBySubjectId(subjectId);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    protected int averageMarkOfSubjectOfUniversity(@RequestParam int groupId, @RequestParam int subjectId) {
        logger.debug("Get average mark for subject by id '{}'", subjectId);
        return universityService.getAverageMarkBySubjectNGroup(groupId, subjectId);
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    protected void averageMarkOfSubjectOfUniversity(@RequestParam int id, @RequestParam int groupId,
                                                    @RequestParam String name, @RequestParam String lastName) {
        logger.debug("Save student '{}'", name);
        universityService.save(id, groupId, name, lastName);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    protected Student averageMarkOfSubjectOfUniversity(@RequestParam int id) {
        logger.debug("Get student '{}'", id);
        return universityService.getById(id);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    protected Iterable<Student> averageMarkOfSubjectOfUniversity() {
        logger.debug("Get students");
        return universityService.findAll();
    }
}
