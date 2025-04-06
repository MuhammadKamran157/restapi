package com.example.restapi.controller

import com.example.restapi.model.student
import com.example.restapi.repository.StudentRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController // meaning it handles HTTP requests and returns data (usually JSON).
@RequestMapping("/student") // API URL: http://localhost:8080/students
class StudentController(private val studentRepository: StudentRepository) {


    @PostMapping
    fun addStudent(@RequestBody student: student): ResponseEntity<student> {
        return try {
            val savedStudent = studentRepository.save(student)
            ResponseEntity.ok(savedStudent)
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
        }
    }


    @GetMapping
    fun getAllStudents(): List<student> {
        return studentRepository.findAll() // Fetch all students from MongoDB
    }

    /*@GetMapping
    fun getAllStudents(@RequestParam(required = false) name: String?): List<student> {
        return if (name != null) {
            studentRepository.findByStudentName(name) // Fetch students by Student_Name
        } else {
            studentRepository.findAll() // Return all students if no name is provided
        }
    }*/


    @PutMapping("/{id}")
    fun updateStudent(@PathVariable id: Int, @RequestBody updatedStudent: student): ResponseEntity<String> {
        return try {
            if (studentRepository.existsById(id)) {
                val existingStudent = studentRepository.findById(id).get()
                val newStudent = existingStudent.copy(
                    studentName = updatedStudent.studentName,
                    studentGender = updatedStudent.studentGender,
                    rollNumber = updatedStudent.rollNumber
                )
                studentRepository.save(newStudent)
                ResponseEntity.ok("Student with ID $id updated successfully")
            } else {
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with ID $id not found")
            }
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating student: ${e.message}")
        }
    }


    @DeleteMapping("/{id}")
    fun deleteStudent(@PathVariable id: Int): ResponseEntity<String> {
        return try {
            if (studentRepository.existsById(id)) {
                studentRepository.deleteById(id)
                ResponseEntity.ok("Student with ID $id deleted successfully")
            } else {
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with ID $id not found")
            }
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting student: ${e.message}")
        }
    }

}


