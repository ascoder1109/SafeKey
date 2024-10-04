package com.ascoder1109.securekey.model

import jakarta.persistence.*
import lombok.Data

@Entity
@Data
@Table(name = "user")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "name" ,nullable = false)
    val name: String,

    @Column(name="email",nullable = false, unique = true)
    val email: String,

    @Column(name="password",nullable = false)
    val password: String
)