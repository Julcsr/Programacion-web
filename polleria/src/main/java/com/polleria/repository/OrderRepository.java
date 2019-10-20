package com.polleria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.polleria.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
