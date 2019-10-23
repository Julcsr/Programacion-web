package com.polleria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.polleria.entity.Delivery;


@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
	@Query(value="SELECT * FROM deliveries WHERE delivery_id=?",nativeQuery = true)
	public List<Delivery> fechfindByid(Long id);
}
