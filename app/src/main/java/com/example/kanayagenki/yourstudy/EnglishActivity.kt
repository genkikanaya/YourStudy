package com.example.kanayagenki.yourstudy

import android.media.AudioAttributes
import android.media.SoundPool
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import kotlinx.android.synthetic.main.activity_english.*

class EnglishActivity : AppCompatActivity() {

    var questionAlphabet: String = ""

    val alphabets = mapOf(
        "A" to "エー",
        "B" to "ビー",
        "C" to "シー",
        "D" to "ディー",
        "E" to "イー",
        "F" to "エフ",
        "G" to "ジー",
        "H" to "エイチ",
        "I" to "アイ",
        "J" to "ジェー",
        "K" to "ケー",
        "L" to "エル",
        "M" to "エム",
        "N" to "エヌ",
        "O" to "オー",
        "P" to "ピー",
        "Q" to "キュー",
        "R" to "アール",
        "S" to "エス",
        "T" to "ティー",
        "U" to "ユー",
        "V" to "ブイ",
        "W" to "ダブリュ",
        "X" to "エックス",
        "Y" to "ワイ",
        "Z" to "ゼット")

    private lateinit var soundPool: SoundPool
    private var soundA = 0
    private var soundB = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_english)

//        画面初期アクセス時のアルファベット設定
        questionAlphabet = randomAlphabet()
        settingQuestion(questionAlphabet)


//       次の問題
        val nextButton = findViewById(R.id.nextButton) as Button
        nextButton.setOnClickListener {
            questionAlphabet = randomAlphabet()
            settingQuestion(questionAlphabet)
            engsishAnswer.text = ""
        }

//        こたえ
        val checkButton = findViewById(R.id.checkButton) as Button
        checkButton.setOnClickListener {
            engsishAnswer.text = alphabets[questionAlphabet]
        }
    }

    override fun onResume() {
        super.onResume()
        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_ASSISTANT)
            .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
            .build()
        soundPool = SoundPool.Builder()
            .setAudioAttributes(audioAttributes)
            .setMaxStreams(2)
            .build()
        soundA = soundPool.load(this, R.raw.alphabet02_a_01, 1)
        soundB = soundPool.load(this, R.raw.alphabet02_b_01, 1)
//        TODO
//        アルファベット分のローディング
    }

    override fun onPause() {
        super.onPause()
        soundPool.release()
    }


//    ランダムのアルファベットを求める
    private fun randomAlphabet(): String = alphabets.keys.random()

//    問題欄にアルファベットをセットする
    private fun settingQuestion(word: String) {
        alphabet.text = word
    }
}
