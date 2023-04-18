package com.tamertokbaev.momari.helpers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tamertokbaev.momari.R
import com.tamertokbaev.momari.models.Review

class ReviewsAdapter(private val reviews: ArrayList<Review>): RecyclerView.Adapter<ReviewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.fragment_review,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(reviews[position])
    }

    override fun getItemCount(): Int {
        return reviews.size
    }

    class ViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView) {
        var author = itemView.findViewById<TextView>(R.id.review_author)
        var content = itemView.findViewById<TextView>(R.id.review_content)

        // Binding fetched data to UI components from our fragment item!
        fun bind(review: Review) {
            author.text = review.user?.name
            content.text = review.content
        }
    }
}

