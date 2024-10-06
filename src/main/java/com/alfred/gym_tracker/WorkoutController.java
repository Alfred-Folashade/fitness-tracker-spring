package com.alfred.gym_tracker;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkoutController {
	@Autowired
	WorkoutRepo workoutRepo;
	
	@GetMapping(value="/workouts")
	public List<Workout> getAllWorkouts(){
		return workoutRepo.findAll();
	}
	
	@GetMapping(value="/getWorkoutById{id}")
	public Optional<Workout> getWorkoutById(@PathVariable Long id) {
		return workoutRepo.findById(id);
	}
	
	@DeleteMapping("/deleteWorkoutById{id}")
	public void deleteById(@PathVariable Long id) {
		Workout deleteWorkout = workoutRepo.findById(id).get();
		workoutRepo.delete(deleteWorkout);
	}
	
	
	@PostMapping("/updateWorkoutById{id}")
	public void updateWorkoutById(@PathVariable Long id, @RequestBody Workout workout) {
		Workout updateWorkout = workoutRepo.findById(id).get();
		updateWorkout.setExercises(workout.getExercises());
		updateWorkout.setMuscleGroup(workout.getMuscleGroup());
		workoutRepo.save(updateWorkout);
	}
	
	@PostMapping("/saveWorkout")
	public void saveUser(@RequestBody Workout newWorkout) {
		workoutRepo.save(newWorkout);
	}
}
