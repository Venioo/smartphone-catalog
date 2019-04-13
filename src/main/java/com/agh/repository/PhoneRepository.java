package com.agh.repository;

import com.agh.jpa.Phone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends CrudRepository<Phone, Long> {
}