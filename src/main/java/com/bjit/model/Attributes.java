package com.bjit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="attribute")
public class Attributes{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="id")
	private int id;
	
	@Column(name="id")
	private String type;
	
	@Column(name="product_id", unique=true, nullable=false)
	@GenericGenerator(name="gen", strategy="foreign", parameters={ 
			@Parameter(name="property", value="product")
	})
	private int productId;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Product product;

	@OneToOne(mappedBy="attribute")
	@Cascade(value=org.hibernate.annotations.CascadeType.ALL)
	private Order order;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
