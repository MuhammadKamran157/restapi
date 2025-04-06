package com.example.restapi.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "Student")  //This tells Spring that this class represents a MongoDB "Student" collection.
data class student(

    @Id
    @Field("_id")  // Map to MongoDB's "id" field
    val studentId: Int,

    @Field("Student_Name")
    val studentName: String,

    @Field("Student_Gender")  // Map to MongoDB's "F_Name" field
    val studentGender: String,

    @Field("Roll_Number")  // Map to MongoDB's "Roll" field
    val rollNumber: String
)
