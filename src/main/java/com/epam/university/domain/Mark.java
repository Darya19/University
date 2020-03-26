package com.epam.university.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Mark {

    @Id
    @GeneratedValue
    @Column(name = "MARKID")
    private int markId;
    @Column(name = "STUDENTID")
    private int studentId;
    @Column(name = "SUBJECTID")
    private int subjectId;

    public Mark() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentCode) {
        this.studentId = studentCode;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getMarkId() {
        return markId;
    }

    public void setMarkId(int mark) {
        this.markId = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mark mark1 = (Mark) o;

        if (studentId != mark1.studentId) return false;
        if (subjectId != mark1.subjectId) return false;
        return markId == mark1.markId;
    }

    @Override
    public int hashCode() {
        int result = studentId;
        result = 31 * result + subjectId;
        result = 31 * result + markId;
        return result;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "studentCode=" + studentId +
                ", subjectId=" + subjectId +
                ", mark=" + markId +
                '}';
    }
}
