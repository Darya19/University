package com.epam.university.dao;

import com.epam.university.domain.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Integer> {

    List<Mark> findAllByStudentId(int studentId);

    List<Mark> findAllBySubjectId(int subjectId);

}
