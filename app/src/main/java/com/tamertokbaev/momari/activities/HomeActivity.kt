package com.tamertokbaev.momari.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tamertokbaev.momari.MyJsInterface
import com.tamertokbaev.momari.R
import com.tamertokbaev.momari.globals.Constants


class HomeActivity : AppCompatActivity() {
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigationView: BottomNavigationView = findViewById(R.id.navigation)
        val navController = findNavController(findViewById(R.id.nav_host_fragment_activity_guest))

        navigationView.setupWithNavController(navController)
//        navigationView.setOnNavigationItemSelectedListener { item ->
//            when(item.itemId) {
//                R.id.fragment_home -> {
//                    Log.d("Navigation listener", "Navigating to new page!!!")
//                    navController.navigate(R.id.fragment_home)
//                    true
//                }
//                else -> false
//            }
//        }
        val preferences = getSharedPreferences(Constants.APP_SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val bearerToken = preferences.getString(Constants.APP_SHARED_USER_TOKEN_KEY, "")

        val webView = findViewById<WebView>(R.id.webViewMain)
        // WebViewClient allows you to handle
        // onPageFinished and override Url loading.
        webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient()
        // this will load the url of the website
        webView.loadUrl("http://10.0.2.2:3000")

        // this will enable the javascript settings, it can also allow xss vulnerabilities
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.addJavascriptInterface(MyJsInterface(this, bearerToken!!), "Android")

        // if you want to enable zoom feature
        webView.settings.setSupportZoom(true)
    }

    fun signOut(view: View) {
        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
        finish()
    }


}