package com.hampcode.articlesapp.model;
	

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "deliveries")
public class Delivery {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="delivery_id")
	private Long id;

	@NotEmpty(message="Error al registrar")
	@Column(name="customer")
	private String customer;

	
	@ManyToOne
	@JoinColumn(name="id_motorized")
	private Employee motorized;

	@ManyToOne
	@JoinColumn(name="id_recepcionist")
	private Employee recepcionist;
	
	@ManyToOne
	@JoinColumn(name="id_order")
	private Order order;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Employee getMotorized() {
		return motorized;
	}

	public void setMotorized(Employee motorized) {
		this.motorized = motorized;
	}

	public Employee getRecepcionist() {
		return recepcionist;
	}

	public void setRecepcionist(Employee recepcionist) {
		this.recepcionist = recepcionist;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	


	
}
