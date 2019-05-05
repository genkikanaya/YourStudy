package com.example.kanayagenki.yourstudy

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val subjects = arrayOf("さんすう", "えいご", "ギリシアもじ")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, subjects)
        subjectView.adapter = adapter

        subjectView.setOnItemClickListener { _, _, position, _ ->
            when(position) {
                0 -> {
//                    算数問題
                    val intent = Intent(this, MathActivity::class.java)
                    startActivity(intent)
                }
                1 -> {
//                    英語問題
                    val intent = Intent(this, EnglishActivity::class.java)
                    startActivity(intent)
                }
                2 -> {
//                    ギリシア文字問題
                    val intent = Intent( this, GreekCharacterActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}
