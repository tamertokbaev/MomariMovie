package com.tamertokbaev.momari

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import com.tamertokbaev.momari.globals.Constants

class CatalogFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_catalog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val preferences = view.context.getSharedPreferences(Constants.APP_SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val bearerToken = preferences.getString(Constants.APP_SHARED_USER_TOKEN_KEY, "")

        val webView = view.findViewById<WebView>(R.id.webViewCatalog)
        // WebViewClient allows you to handle
        // onPageFinished and override Url loading.
        webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient()
        // this will load the url of the website
        webView.loadUrl("http://10.0.2.2:3000")

        // this will enable the javascript settings, it can also allow xss vulnerabilities
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.addJavascriptInterface(MyJsInterface(view.context, bearerToken!!), "Android")

        // if you want to enable zoom feature
        webView.settings.setSupportZoom(true)

        Log.d("WEBVIEW", webView.url.toString())
    }
}