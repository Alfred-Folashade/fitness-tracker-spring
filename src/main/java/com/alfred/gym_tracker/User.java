package com.alfred.gym_tracker;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Users")
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
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL) 
	private List<Workout> workouts;
	
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
	public void setHeight(double height) {
		this.height =  height;
	}
	
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight =  weight;
	}
	
	public double getBmi() {
		return bmi;
	}
	public void setBmi(double bmi) {
		this.bmi =  bmi;
	}
	
	public List<Workout> getWorkout() {
        return workouts;
    }

    public void setWorkout(List<Workout> workouts) {
        this.workouts = workouts;
    }
}
