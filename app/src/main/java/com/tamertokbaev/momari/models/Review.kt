package com.tamertokbaev.momari.models

data class Review(
    val id: Int?,
    val user_id: Int?,
    val book_id: Int?,
    val content: String?,
    val user: User?
)
