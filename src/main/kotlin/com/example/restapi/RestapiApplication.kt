package com.example.restapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication //This annotation marks the class as the starting point for the Spring Boot application.
class RestapiApplication

fun main(args: Array<String>) { //The main function (entry point) for the Kotlin application
	runApplication<RestapiApplication>(*args)  //  This starts the Spring Boot application.
}


