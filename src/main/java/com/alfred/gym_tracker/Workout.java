package com.alfred.gym_tracker;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Workout {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String muscleGroup;
	
	@OneToMany(mappedBy = "workout", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Exercise> exercises;
	
	@ManyToOne  // Many workouts belong to one user
    @JoinColumn(name = "user_id")  // Foreign key in the Workout table
    private User user;
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
       
    }
    
    public String getName() {
    	return name;
    }
    
    public void setName(String name ) {
    	 this.name =name;
    }
    
    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
    
    public String getMuscleGroup() {
    	return muscleGroup;
    }
    
    public void setMuscleGroup(String muscleGroup) {
    	this.muscleGroup = muscleGroup;
    }

}
