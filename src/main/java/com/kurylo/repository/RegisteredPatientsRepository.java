package com.kurylo.repository;

import com.kurylo.domain.RegisteredPatients;
import org.springframework.data.repository.CrudRepository;

public interface RegisteredPatientsRepository extends CrudRepository<RegisteredPatients, Long> {
}
