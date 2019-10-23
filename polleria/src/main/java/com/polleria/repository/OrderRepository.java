package com.polleria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.polleria.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
