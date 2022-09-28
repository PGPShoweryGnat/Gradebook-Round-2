package com.cst438.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository <Course, Integer> {
   public Course findByTitle (String title);
   
   @Query("select c from Course c where c.course_id=:course_id")
   Course findByCourse_id(int course_id);
}
