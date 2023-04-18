package com.tamertokbaev.momari.models

data class BookResponse(
    val message: String,
    val booksFeatured: ArrayList<Book>,
    val genres: ArrayList<String>
)
