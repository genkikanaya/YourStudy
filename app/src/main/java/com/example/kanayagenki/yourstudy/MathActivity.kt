package com.example.kanayagenki.yourstudy

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_math.*
import kotlin.random.Random


class MathActivity : AppCompatActivity() {

//    回答の選択肢
    private val answerSpinnerItems = (0..10).toList()
//    計算問題の最大値
    private val maxNumber = 10

    private var num1: Int = 0
    private var num2: Int = 0
    private var sign: String = ""
    private var answer: Int = 0
    private var questionTriple: Triple<Int, Int, String> = Triple(num1, num2, sign)

    private val signs = listOf("+", "-")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math)

        this.questionTriple = randomItem()
        this.num1 = this.questionTriple.first
        this.num2 = this.questionTriple.second
        this.sign = this.questionTriple.third

        settingsText(num1, num2, sign)

//        arrayadapter
        val adapter = ArrayAdapter(applicationContext,R.layout.spinner_item,answerSpinnerItems)

        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item)

        spinner.adapter = adapter

//        リスナー登録
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

//        次の問題
        val nextButton = findViewById(R.id.nextButton) as Button
        nextButton.setOnClickListener {

            this.questionTriple = randomItem()
            this.num1 = this.questionTriple.first
            this.num2 = this.questionTriple.second
            this.sign = this.questionTriple.third

            settingsText(num1, num2, sign)

        }
//        答え合わせ
        val checkButton = findViewById(R.id.checkButton) as Button
        checkButton.setOnClickListener {
            when(sign){
                "+" -> {
                    answer = num1 + num2
                }
                "-" -> {
                    answer = num1 - num2
                }
            }
            if (spinner.getSelectedItem() == answer) {
                showToast(this@MathActivity, "ok")
            } else {
                showToast(this@MathActivity, "ng")
            }
        }
    }

    private fun randomItem() : Triple<Int, Int, String> {
//        ランダム値ロジック
//        最大値maxNumberいないの計算
        var item1 :Int = 0
        var item2 :Int = 0
        val item3 = signs.random()

        when (item3) {
            "+" -> {
                item1 = Random.nextInt(0, maxNumber)
                item2 = Random.nextInt(maxNumber - item1)
            }
            "-" -> {
                item1 = Random.nextInt(0, maxNumber)
                item2 = Random.nextInt(0, item1)
            }
        }

        return Triple(item1, item2, item3)
    }

    private fun settingsText(num1: Int, num2: Int, sign: String) {
//        問題欄にアイテムをセットするs
        number1.text = num1.toString()
        number2.text = num2.toString()
        signText.text = sign

    }

    private fun showToast(context: Context, answerCollectIncollect: String){
//        Toastを表示する
        val inflate = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view :View
        if (answerCollectIncollect == "ok") {
            view = inflate.inflate(R.layout.ok_toast, null)
        } else {
            view = inflate.inflate(R.layout.ng_toast, null)
        }
        Toast(context).run {
            this.view = view
            duration = Toast.LENGTH_SHORT
            setGravity(Gravity.BOTTOM,0,250)
            show()
        }
    }


}