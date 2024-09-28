package com.alfred.gym_tracker;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepo extends JpaRepository<Workout,Long>{

}
