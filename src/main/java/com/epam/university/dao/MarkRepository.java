package com.epam.university.dao;

import com.epam.university.domain.Mark;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkRepository extends CrudRepository<Mark, Integer> {

    List<Mark> findAllByStudentId(int studentId);

    List<Mark> findAllBySubjectId(int subjectId);

}
