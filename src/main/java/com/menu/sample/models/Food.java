package com.menu.sample.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "food")
public class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "date_serve")
	private String dateServe;
	@Column(name="price")
	private Long price;
	@Column(name="create_date")
	private Date createDate;
	@Column(name="update_date")
	private Date updateDate;
	
	public Food() {
		
	}
	
	public Food(Long id, String name, String description, Date createDate, Long price, String dateServe, Date updateDate) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.createDate = createDate;
		this.price = price;
		this.dateServe = dateServe;
		this.updateDate = updateDate;
	}
	
	public String toString() {
		return "FoodEntity [id=" + id + ", name=" + name +
                ", description=" + description + ", date_serve=" + getDateServe()+ 
                ", price=" + price+ ", create_date="+ createDate+ ", update_date="+updateDate+"]";
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDateServe() {
		return dateServe;
	}

	public void setDateServe(String dateServe) {
		this.dateServe = dateServe;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
}
