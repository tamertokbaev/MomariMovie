package com.tamertokbaev.momari.services

import com.tamertokbaev.momari.models.BookOwnedResponse
import com.tamertokbaev.momari.models.BookResponse
import com.tamertokbaev.momari.models.Review
import com.tamertokbaev.momari.models.ReviewResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface BookFetchService {
    @GET("books")
    fun getFeaturedBooks() : Call<BookResponse>

    @GET("books/owned")
    fun getOwnedBooks(@Query("token") token: String): Call<BookOwnedResponse>

    @GET("books/search")
    fun searchBooks(@Query("slug") slug: String): Call<BookResponse>

    @GET("books/reviews")
    fun getReviews(@Query("book_id") bookId: Int): Call<ReviewResponse>

    @POST("books/leaveReview")
    fun leaveReview(@Query("token") token: String, @Body review: Review): Call<ReviewResponse>
}