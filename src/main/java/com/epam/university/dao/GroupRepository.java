package com.epam.university.dao;

import com.epam.university.domain.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends CrudRepository<Group, Integer> {

    List<Group> findAllByFacultyId(int facultyId);
}
