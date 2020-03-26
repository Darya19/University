package com.epam.university.controller;

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

    @RequestMapping(value = "/subject/", method = RequestMethod.GET)
    protected int getAverageMarkBySubjectId(@RequestParam int subjectId) {
        logger.debug("Get average mark for subject by id '{}'", subjectId);
        return universityService.getAverageMarkBySubjectId(subjectId);
    }

    @RequestMapping(value = "/all/", method = RequestMethod.GET)
    protected int averageMarkOfSubjectOfUniversity(@RequestParam int groupId, @RequestParam int subjectId) {
        logger.debug("Get average mark for subject by id '{}'", subjectId);
        return universityService.getAverageMarkBySubjectNGroup(groupId, subjectId);
    }
}
