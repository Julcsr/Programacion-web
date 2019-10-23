package com.polleria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.polleria.entity.Office;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Long>{

}
