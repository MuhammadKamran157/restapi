package com.example.restapi.model

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "Teacher")
data class Teacher(
    val id: Int,
    val name: String,
    val F_Name: String,
    val Subject: String
)