package com.example.task_023

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlin.system.exitProcess

class BrowserActivity : AppCompatActivity() {

    private lateinit var toolbarMain: Toolbar
    private lateinit var webViewWV: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browser)

        init() 

        setSupportActionBar(toolbarMain)
        title = "Мобильный браузер."

        webViewWV.webViewClient = WebViewClient()
        val dataUrl = intent.getStringExtra("dataUrl")!!.toString()
        webViewWV.loadUrl(dataUrl.toString())
    }

    private fun init() {
        toolbarMain = findViewById(R.id.toolbarMain)
        webViewWV = findViewById(R.id.webViewWV)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return  true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.exitMenuMain->{
                moveTaskToBack(true);
                exitProcess(-1)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}