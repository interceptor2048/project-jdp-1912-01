package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
    @Override
    Group save(Group group);

    @Override
    List<Group> findAll();

    Group findById(Long id);

    void deleteById(Long id);
}
