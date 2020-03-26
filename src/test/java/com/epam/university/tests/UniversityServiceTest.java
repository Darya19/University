package com.epam.university.tests;

import com.epam.university.controller.UniversityController;
import com.epam.university.service.UniversityService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(UniversityController.class)
public class UniversityServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UniversityService universityService;

    @Test
    public void averageMarkOfSubjectOfUniversityTest() {
        int subjectId = 1;
        int result = universityService.getAverageMarkBySubjectId(subjectId);

        Assert.assertEquals("Incorrect average mark", subjectId, result);
    }

    @Test
    public void averageMarkOfStudentTest() {
        int studentCode = 1;
        int result = universityService.getAverageMarkByStudentId(studentCode);

        Assert.assertEquals("Incorrect average mark", studentCode, result);
    }

    @Test
    public void averageMarkOfSubjectOfGroupTest() {
        int groupId = 151;
        int subjectId = 1;

        int result = universityService.getAverageMarkBySubjectNGroup(groupId, subjectId);

        Assert.assertEquals("Incorrect average mark", groupId, result);
    }
}
