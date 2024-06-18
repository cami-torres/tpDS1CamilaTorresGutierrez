package ar.edu.udemm.tpDiseno.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.udemm.tpDiseno.Entity.Qualification;

public interface QualificationRepository extends JpaRepository<Qualification, Long> {
    List<Qualification> findAllByUsername(String username);
}
