package com.cst438.services;


import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cst438.domain.Course;
import com.cst438.domain.CourseDTOG;
import com.cst438.domain.CourseRepository;
import com.cst438.domain.Enrollment;
import com.cst438.domain.EnrollmentDTO;
import com.cst438.domain.EnrollmentRepository;


public class RegistrationServiceMQ extends RegistrationService {

	@Autowired
	EnrollmentRepository enrollmentRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public RegistrationServiceMQ() {
		System.out.println("MQ registration service ");
	}

	// ----- configuration of message queues

	@Autowired
	Queue registrationQueue;


	// ----- end of configuration of message queue

	// receiver of messages from Registration service
	
	@RabbitListener(queues = "gradebook-queue")
	@Transactional
	public void receive(EnrollmentDTO enrollmentDTO) {
		
		//TODO  complete this method in homework 4
	   //Same logic as RegistrationServiceRest
	   //Get message from message queue
	   //Going to contain an enrollmentDTO object
	   //Create enrollment entity
	   //Save it to enrollment table in the gradebook database
	   
	   System.out.println("Received RabbitMQ enrollment");
	   Course c  = courseRepository.findByCourse_id(enrollmentDTO.course_id);
	   Enrollment e = new Enrollment();
	   //Set everything
	   e.setCourse(c);
	   e.setStudentEmail(enrollmentDTO.studentEmail);
	   e.setStudentName(enrollmentDTO.studentName);
	   //Then save
	   enrollmentRepository.save(e);
		
	}

	// sender of messages to Registration Service
	@Override
	public void sendFinalGrades(int course_id, CourseDTOG courseDTO) {
		 
		//TODO  complete this method in homework 4
	   //Similar to RegistrationServiceRest, but with Rabbit Template
	   
	   rabbitTemplate.convertAndSend(registrationQueue.getName(), courseDTO);
	   System.out.println("(RegistrationServiceMQ)Sending final grades " +course_id+ " "+courseDTO);
		
	}

}
