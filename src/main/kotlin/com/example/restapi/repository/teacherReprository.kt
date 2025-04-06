package com.example.restapi.repository

import com.example.restapi.model.Teacher
import org.springframework.data.mongodb.repository.MongoRepository

interface TeacherRepository : MongoRepository<Teacher, String>