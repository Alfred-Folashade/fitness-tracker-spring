package com.alfred.gym_tracker;

import java.security.Principal;
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
	
	@Autowired
	UserRepo userRepo;
	
	@GetMapping("/")
	public String getAllWorkouts(Model model){
		model.addAttribute("allworkouts", workoutService.getAllWorkouts());
		return "index";
		
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
	public String saveWorkout(@ModelAttribute("newWorkout") Workout newWorkout, Principal principal) {
		User user = userRepo.findByEmail(principal.getName());
		newWorkout.setUser(user);
		workoutService.saveWorkout(newWorkout);
		
		return "index"; 
	}
	
	@GetMapping("/viewWorkouts")
	public String viewWorkouts(Model model, Principal principal) {
		User user = userRepo.findByEmail(principal.getName());
		model.addAttribute("allworkoutsuser", user.getWorkout());
		return "viewworkouts";
	}
	
	
}
