package com.hampcode.articlesapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long id;
	
	@NotEmpty(message="Error al registrar")
	@Column(name = "order_name", nullable = false, length = 50)
	private String name;
	
	
	
	//@NotEmpty(message="Error al registrar")
	@Column(name = "order_price", nullable = false, length = 50)
	private Long price;
	
	
	@NotEmpty(message="Error al registrar")
	@Lob
	@Type(type = "org.hibernate.type.TextType")
	private String ingredients;
	
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
