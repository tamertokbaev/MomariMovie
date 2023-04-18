package com.tamertokbaev.momari

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.fragment.findNavController
import com.tamertokbaev.momari.models.*
import com.tamertokbaev.momari.services.CheckoutService
import com.tamertokbaev.momari.services.ServiceBuilder


class CardEnterFragment : Fragment() {
    private val destinationService = ServiceBuilder.buildService(CheckoutService::class.java)

    private var book: Book? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_book_inner, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    private fun navigateBackListener(view: View) {
        val navigateBack = view.findViewById<TextView>(R.id.navigate_back)
        navigateBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}