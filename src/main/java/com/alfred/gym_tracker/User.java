package com.alfred.gym_tracker;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column 
	private String name;
	
	@Column
	private int age;
	
	@Column
	private double weight;
	
	@Column
	private double height;
	
	@Column
	private double bmi = weight / height * height;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id =  id;
	}
	
	public String getName () {
		return name;
	}
	public void setFirstName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age =  age;
	}
	
	public double getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height =  height;
	}
	
	public double getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight =  weight;
	}
	
	public double getBmi() {
		return bmi;
	}
	public void setBmi(int bmi) {
		this.bmi =  bmi;
	}
}
