package com.tamertokbaev.momari

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tamertokbaev.momari.globals.Constants
import com.tamertokbaev.momari.helpers.CheckoutAdapter
import com.tamertokbaev.momari.models.UserCheckoutResponse
import com.tamertokbaev.momari.services.CheckoutService
import com.tamertokbaev.momari.services.ServiceBuilder

class CheckoutFragment : Fragment() {
    private val destinationService = ServiceBuilder.buildService(CheckoutService::class.java)
    private var bearerToken: String? = null
    private var catalog_recycler: RecyclerView? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_checkout, container, false)
    }
}