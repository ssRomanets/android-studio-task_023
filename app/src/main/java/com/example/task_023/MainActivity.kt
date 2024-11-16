package com.example.task_023

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private lateinit var toolbarMain: Toolbar
    private lateinit var gridViewGV: GridView

    private var list = mutableListOf(
        GridViewModal("yandex", "https://ya.ru/"),
        GridViewModal("urban", "https://urban-university.ru/"),
        GridViewModal("google", "https://www.google.ru/"),
        GridViewModal("github", "https://github.com/")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        setSupportActionBar(toolbarMain)
        title = "Мобильный браузер."

        val adapter = GridViewAdapter(list = list, this@MainActivity)
        gridViewGV.adapter = adapter

        gridViewGV.onItemClickListener = AdapterView.OnItemClickListener {_, _, position, _ ->
            Toast.makeText(
                applicationContext,
                "Выбран сайт: ${list[position].dataUrl}",
                Toast.LENGTH_SHORT
            ).show()

            val intentOut = Intent(this, BrowserActivity::class.java)
            intentOut.putExtra("dataUrl", list[position].dataUrl.toString())
            startActivity(intentOut)
        }
    }

    private fun init() {
        toolbarMain = findViewById(R.id.toolbarMain)
        gridViewGV = findViewById(R.id.gridViewGV)
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