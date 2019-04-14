package com.example.kanayagenki.yourstudy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
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

    var num1: Int = 0
    var num2: Int = 0
    var questionPair: Pair<Int, Int> = Pair(num1, num2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math)

//        var(num1, num2) = randomItem()
        this.questionPair = randomItem()
        this.num1 = this.questionPair.first
        this.num2 = this.questionPair.second

//        当面四則演算は足し算のみとする
        var sign = "+"

        settingsText(num1, num2, sign)

//        arrayadapter
        val adapter = ArrayAdapter(applicationContext,R.layout.spinner_item,answerSpinnerItems)

        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item)

        spinner.adapter = adapter

//        リスナー登録
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                val spinnerParent = parent as Spinner
//                val item = spinnerParent.selectedItem as String
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

//        次の問題
        val nextButton = findViewById(R.id.nextButton) as Button
        nextButton.setOnClickListener {

//            var(num1, num2) = randomItem()
            this.questionPair = randomItem()
            this.num1 = this.questionPair.first
            this.num2 = this.questionPair.second

//        当面四則演算は足し算のみとする
            var sign = "+"

            settingsText(num1, num2, sign)

        }
        //        答え合わせ
//        TODO 次の問題にいったときnum1とnum2の値が更新されない
        val checkButton = findViewById(R.id.checkButton) as Button
        checkButton.setOnClickListener {
            if (spinner.getSelectedItem() == num1 + num2) {
                Toast.makeText(this@MathActivity, "せいかい！！！", Toast.LENGTH_LONG ).show()
            }
            else {
                Toast.makeText(this@MathActivity, "ざんねん！！！", Toast.LENGTH_LONG ).show()

            }
        }
    }

    private fun randomItem() : Pair<Int, Int> {
//        ランダム値ロジック
//        number1に０〜１０の数をランダムで求める
//        number2は、number1に対して数を足した時に１０以下になる値をランダムで求める。
//        number2 <= 10 - number1　を満たす乱数

        val item1 = Random.nextInt(0, 10)
        val item2 = Random.nextInt(10 - item1)
        return Pair(item1, item2)
    }

    private fun settingsText(num1: Int, num2: Int, sign: String) {
//        問題欄にアイテムをセットするs
        number1.text = num1.toString()
        number2.text = num2.toString()
        signText.text = sign

    }


}
