package org.codefix.codefixapi.repository;

import org.codefix.codefixapi.model.Reparo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReparoRepository extends JpaRepository<Reparo, Long> {
}
