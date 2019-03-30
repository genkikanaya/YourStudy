package com.example.kanayagenki.yourstudy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_math.*
import kotlin.random.Random


class MathActivity : AppCompatActivity() {

//    回答の選択肢
    private val answerSpinnerItems = (0..10).toList()

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

//        arrayadapter
        val adapter = ArrayAdapter(applicationContext,R.layout.spinner_item,answerSpinnerItems)

        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item)

        spinner.adapter = adapter

//        リスナー登録
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String
//                textView.text = item
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }





    }
}
