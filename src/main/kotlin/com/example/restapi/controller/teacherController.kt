package com.example.restapi.controller

import com.example.restapi.model.Teacher
import com.example.restapi.repository.TeacherRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/teachers")
class TeacherController(private val teacherRepository: TeacherRepository) {

    @GetMapping
    fun getAllTeachers(): List<Teacher> = teacherRepository.findAll()

    @PostMapping
    fun createTeacher(@RequestBody teacher: Teacher): Teacher = teacherRepository.save(teacher)

    @GetMapping("/{id}")
    fun getTeacherById(@PathVariable id: String): Teacher? = teacherRepository.findById(id).orElse(null)

    @DeleteMapping("/{id}")
    fun deleteTeacher(@PathVariable id: String) = teacherRepository.deleteById(id)
}
