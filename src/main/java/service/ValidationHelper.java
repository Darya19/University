package service;

import Exceptions.EmptyFacultyException;
import Exceptions.EmptyGroupException;
import Exceptions.InvalidMarkException;
import Exceptions.NullSubjectException;
import dao.GroupDao;
import dao.MarkDao;
import dao.StudentDao;
import domain.Faculty;
import domain.Group;
import domain.Mark;
import domain.Student;

import java.util.List;

public class ValidationHelper {
    public void saveFaculty(Faculty faculty) throws EmptyFacultyException {
        GroupDao group = new GroupDao();
        List<Group> listOfGroups = group.getGroupsByFacultyId(faculty.getFacultyId());
        if(listOfGroups.isEmpty()){
throw new EmptyFacultyException("Faculty must have at least one group");
    }
}

    public void saveGroup(Group group) throws EmptyGroupException {
        StudentDao student = new StudentDao();
        List<Student> listOfStudents = student.getStudentsByGroupId(group.getGroupId());
        if(listOfStudents.isEmpty()){
            throw new EmptyGroupException("Group must have at least one student");
        }
    }

    public void saveStudent(Student student) throws NullSubjectException {
        MarkDao mark = new MarkDao();
        List<Integer> listOfSubjectId = null;
        List<Mark> list = mark.getMarksByStudentCode(student.getStudentCode());
        for (int i = 0; i < list.size(); i++) {
            listOfSubjectId.add(list.get(i).getSubjectId());
        }
            if (listOfSubjectId.isEmpty()) {
                throw new NullSubjectException("Student must have at least one subject");
            }

    }

    public void saveMark(Mark mark) throws InvalidMarkException {
        if(mark.getMark() > 10 || mark.getMark() < 0){
            throw new InvalidMarkException("Invalid mark");
        }
    }
}
