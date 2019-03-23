package com.example.kanayagenki.yourstudy

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val subjects = arrayOf("さんすう", "えいご", "ぎりしあもじ")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, subjects)
        subjectView.adapter = adapter

        subjectView.setOnItemClickListener { parent, view, position, id ->
            if (position == 0) {
                val intent = Intent(this, MathActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
