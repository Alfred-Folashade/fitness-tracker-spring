package com.alfred.gym_tracker;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class WorkoutController {
	@Autowired
	WorkoutService workoutService;
	
	@GetMapping(value="/workouts")
	public List<Workout> getAllWorkouts(){
		return workoutService.getAllWorkouts();
	}
	
	@GetMapping(value="/addNewWorkout")
	public String addWorkout(Model model) {
		Workout newWorkout = new Workout();
		model.addAttribute("newWorkout", newWorkout);
		return "workout";
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
	public String saveWorkout(@ModelAttribute("newWorkout") Workout newWorkout) {
		workoutService.saveWorkout(newWorkout);
		System.out.println(newWorkout);
		return "index";
	}
}
