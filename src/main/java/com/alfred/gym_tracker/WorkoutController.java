package com.alfred.gym_tracker;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkoutController {
	@Autowired
	WorkoutRepo workoutRepo;
	
	
}
