package com.alfred.gym_tracker;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Workout {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String muscleGroup;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Exercise> exercises;
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

}
