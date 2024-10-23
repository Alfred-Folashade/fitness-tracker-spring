package com.alfred.gym_tracker;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class WorkoutService {
	@Autowired
	WorkoutRepo workoutRepo;
	
	@Autowired
    ExerciseRepo exerciseRepo;
	
	public List<Workout> getAllWorkouts(){
		return workoutRepo.findAll();
	}
	
	
	public Optional<Workout> getWorkoutById(Long id) {
		return workoutRepo.findById(id);
	}
	
	
	public void deleteById(Long id) {
		Workout deleteWorkout = workoutRepo.findById(id).get();
		workoutRepo.delete(deleteWorkout);
	}
	

	public void updateWorkoutById( Long id, Workout workout) {
		Workout updateWorkout = workoutRepo.findById(id).get();
		updateWorkout.setExercises(workout.getExercises());
		updateWorkout.setMuscleGroup(workout.getMuscleGroup());
		workoutRepo.save(updateWorkout);
	}
	
	
	public void saveWorkout(Workout newWorkout) {
		workoutRepo.save(newWorkout);
	}
	
	public void addExercise(Long workoutId, int sets, int repetitions, double weight, int restTime) {
		Workout workout = workoutRepo.findById(workoutId)
	            .orElseThrow(() -> new IllegalArgumentException("Workout not found"));

	        Exercise exercise = new Exercise();
	        exercise.setSets(sets);
	        exercise.setRepetitions(repetitions);
	        exercise.setWeight(weight);
	        exercise.setRestTime(restTime);

	        // Save the new exercise
	        Exercise savedExercise = exerciseRepo.save(exercise);

	        // Add the exercise to the workout and save the updated workout
	        workout.getExercises().add(savedExercise);
	        workoutRepo.save(workout);

	}
}
