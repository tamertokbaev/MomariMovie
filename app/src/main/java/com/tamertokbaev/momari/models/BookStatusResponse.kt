package com.tamertokbaev.momari.models

data class BookStatusResponse(
    val message: String?,
    val error: String?,
    val bookBoughtStatus: Boolean?,
    val bookFavStatus: Boolean?
)
