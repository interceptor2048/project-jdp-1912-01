package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    @Override
    Group save(Group group);

    @Override
    List<Group> findAll();

    @Override
    Optional<Group> findById(final Long id);

    void deleteById(Long id);
}
