package com.example.kanayagenki.yourstudy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_math.*
import kotlin.random.Random


class MathActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math)

//        ランダム値ロジック
//        number1に０〜１０の数をランダムで求める
//        number2は、number1に対して数を足した時に１０以下になる値をランダムで求める。
//            muber2 <= 10 - number1　を満たす乱数
        var num1 = Random.nextInt(0, 10)
        var num2 = Random.nextInt(10 - num1)

//        当面四則演算は足し算のみとする
        var sign = "+"

        number1.text = num1.toString()
        number2.text = num2.toString()
        signText.text = sign





    }
}
