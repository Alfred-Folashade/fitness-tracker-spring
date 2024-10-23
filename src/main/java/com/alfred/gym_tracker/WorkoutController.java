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
	WorkoutService workoutService;
	
	@GetMapping(value="/workouts")
	public List<Workout> getAllWorkouts(){
		return workoutService.getAllWorkouts();
	}
	
	@GetMapping(value="/getWorkoutById{id}")
	public Optional<Workout> getWorkoutById(@PathVariable Long id) {
		return workoutService.getWorkoutById(id);
	}
	
	@DeleteMapping("/deleteWorkoutById{id}")
	public void deleteById(@PathVariable Long id) {
		workoutService.deleteById(id);
	}
	
	
	@PostMapping("/updateWorkoutById{id}")
	public void updateWorkoutById(@PathVariable Long id, @RequestBody Workout workout) {
		workoutService.updateWorkoutById(id, workout);
	}
	
	@PostMapping("/saveWorkout")
	public void saveWorkout(@RequestBody Workout newWorkout) {
		workoutService.saveWorkout(newWorkout);
	}
}
