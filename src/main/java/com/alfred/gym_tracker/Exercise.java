package com.alfred.gym_tracker;

import jakarta.persistence.*;

@Entity
@Table(name="Exercises")
public class Exercise {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int sets;
	private int repetitions;
	
	private double weight;
	private int  restTime;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id =  id;
	}
	
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight =  weight;
	}
	
	public int getSets() {
		return sets;
	}
	public void setSets(int sets) {
		this.sets =  sets;
	}
	
	public int getRepetitions() {
		return repetitions;
	}
	public void setRepetitions(int repetitions) {
		this.repetitions =  repetitions;
	}
	

	public int getRestTime() {
		return restTime;
	}
	public void setRestTime(int restTime) {
		this.restTime =  restTime;
	}
}
