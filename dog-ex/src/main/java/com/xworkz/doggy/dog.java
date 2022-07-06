package com.xworkz.doggy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Dog")
public class dog {

	@Id
	@Column(name="dog_id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="colour")
	private String colour;
	@Column(name="gender")
	private String gender;
	
	private int weight;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public dog() {
		super();
	}

	


	public dog(int id, String name, String colour, String gender, int weight) {
		super();
		this.id = id;
		this.name = name;
		this.colour = colour;
		this.gender = gender;
		this.weight = weight;
	}

	
	public dog(String name, String colour, String gender, int weight) {
		super();
		this.name = name;
		this.colour = colour;
		this.gender = gender;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "DogEntity [id=" + id + ", name=" + name + ", colour=" + colour + ", gender=" + gender + ", weight="
				+ weight + "]";
	}

	

}
