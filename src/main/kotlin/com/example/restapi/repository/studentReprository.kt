package com.example.restapi.repository

import com.example.restapi.model.student
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : MongoRepository<student, Int> {
    @Query("{ 'Student_Name': ?0 }")
    fun findByStudentName(name: String): List<student>

    @Query("{ '_id': ?0 }")
    fun deleteByStudentId(id: Int): Void
}

//A repository in Spring Boot is a special interface that acts
// as a bridge between your application and the database.
// It helps perform database operations like inserting, updating,
// deleting, and fetching data without writing complex queries.