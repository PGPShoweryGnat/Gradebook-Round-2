package com.cst438.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:3000","http://localhost:3001", "http://localhost:8081"})
public class StudentController{

}
