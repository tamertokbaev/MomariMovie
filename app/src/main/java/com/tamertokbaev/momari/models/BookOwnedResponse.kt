package com.tamertokbaev.momari.models

data class BookOwnedResponse(
    val message: String?,
    val bought: ArrayList<Book>?,
    val fav: ArrayList<Book>?
)
