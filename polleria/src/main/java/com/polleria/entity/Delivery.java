package com.polleria.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "deliveries")
public class Delivery {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="delivery_id")
	private Long id;
	@Column(name="address")
	private String address;
	


	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "delivery_motorized", 
	joinColumns = { @JoinColumn(name = "delivery_id") }, 
	inverseJoinColumns = {@JoinColumn(name = "id") 
})
	
	private List<Employee> motorized=new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "delivery_employee", 
	joinColumns = { @JoinColumn(name = "delivery_id") }, 
	inverseJoinColumns = {@JoinColumn(name = "id") 
})
	private List<Employee> callReceptionists=new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "delivery_order", 
				joinColumns = { @JoinColumn(name = "delivery_id") }, 
				inverseJoinColumns = {@JoinColumn(name = "order_id") 
			})
	
	
	private List<Order> orders = new ArrayList<>();

	@Lob
	@Type(type = "org.hibernate.type.TextType")
	private String description;

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Employee> getMotorized() {
		return motorized;
	}

	public void setMotorized(List<Employee> motorized) {
		this.motorized = motorized;
	}
	

	public List<Employee> getCallReceptionists() {
		return callReceptionists;
	}

	public void setCallReceptionists(List<Employee> callReceptionists) {
		this.callReceptionists = callReceptionists;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdress() {
		return address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAdress(String adress) {
		this.address = adress;
	}

	

}
