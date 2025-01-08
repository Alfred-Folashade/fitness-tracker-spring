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
	private String username;
	
	@Column 
	private String email;
	
	@Column 
	private String password;
	
	@Column
	private int age;
	
	@Column
	private double weight;
	
	@Column
	private double height;
	
	@Column
	private double bmi ; 
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL) 
	private List<Workout> workouts;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id =  id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
		setBmi();
	}
	
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight =  weight;
		setBmi();
	}
	
	public double getBmi() {
		return bmi;
	}
	public void setBmi() {
		bmi =  weight / height * height;
	}
	
	public List<Workout> getWorkout() {
        return workouts;
    }

    public void setWorkout(List<Workout> workouts) {
        this.workouts = workouts;
    }
    
    public String getPassword () {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail () {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
