package service;

import dao.MarkDao;
import dao.StudentDao;
import domain.Mark;
import domain.Student;

import java.util.ArrayList;
import java.util.List;

public class UniversityService {
    public Integer averageMarkOfStudent(Integer studentCode){
        int sumOfMarks = 0;
        int averageMark = 0;
        MarkDao mark = new MarkDao();
      List<Mark> listOfMarks = mark.getMarksByStudentCode(studentCode);
        for (int i = 0; i < listOfMarks.size(); i++) {
            sumOfMarks += listOfMarks.get(i).getMark();
        }
       averageMark = sumOfMarks/listOfMarks.size();
        return averageMark;
    }

    public Integer averageMarkOfSubjectOfUniversity(Integer subjectId){
        int sumOfMarks = 0;
        int averageMark = 0;
        MarkDao mark = new MarkDao();
        List<Mark> listOfMarks = mark.getMarksBySubjectId(subjectId);
        for (int i = 0; i < listOfMarks.size(); i++) {
            sumOfMarks += listOfMarks.get(i).getMark();
        }
        averageMark = sumOfMarks/listOfMarks.size();
        return averageMark;
    }

    public Integer averageMarkOfSubjectOfGroup(Integer groupId, Integer subjectId) {
        int sumOfMarks = 0;
        int averageMark = 0;
        StudentDao student = new StudentDao();
        List<Student> listOfStudents = student.getStudentsByGroupId(groupId);
        List<Integer> listOfStudentsCode = new ArrayList<Integer>();
        for (int i = 0; i < listOfStudents.size(); i++) {
           listOfStudentsCode.add(listOfStudents.get(i).getStudentCode());
        }
        MarkDao mark = new MarkDao();
        List<List<Mark>> listOfMarks = null;
        int count = 0;
        for (int i = 0; i < listOfStudentsCode.size(); i++) {
            listOfMarks.add(mark.getMarksByStudentCode(listOfStudentsCode.get(i)));}
       for(List<Mark> list : listOfMarks){
           for (int i = 0; i < list.size(); i++) {
               if(list.get(i).getSubjectId() == subjectId)
               sumOfMarks += list.get(i).getMark();
               count++;
           }
        }
        averageMark = sumOfMarks/count;
        return averageMark;
    }
}
