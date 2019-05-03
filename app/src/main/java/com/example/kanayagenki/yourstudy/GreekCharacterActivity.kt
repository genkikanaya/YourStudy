package com.example.kanayagenki.yourstudy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import kotlinx.android.synthetic.main.activity_greek_character.*

class GreekCharacterActivity : AppCompatActivity() {

    var questionGreekCharacter: String = ""

    val words = mapOf(
        "α" to "アルファ（Α）",
        "β" to "ベータ（Β）",
        "γ" to "ガンマ（Γ）",
        "δ" to "デルタ（Δ）",
        "ε" to "エプシロン（Ε）",
        "ζ" to "ゼータ（Ζ）",
        "η" to "エータ（Η）",
        "ι" to "イオタ（Ι）",
        "κ" to "カッパ（Κ）",
        "λ" to "ラムダ（Λ）",
        "μ" to "ミュー（Μ）",
        "ν" to "ニュー（Ν）",
        "ξ" to "クシー（Ξ）",
        "ο" to "オミクロン（Ο）",
        "π" to "ピー（パイ）（Π）",
        "ρ" to "ロー（Ρ）",
        "σ" to "シグマ（Σ）",
        "τ" to "タウ（Τ）",
        "υ" to "ユプシロン（Υ）",
        "φ" to "プヒー（ファイ）（Φ）",
        "χ" to "キー（カイ）（Χ）",
        "ψ" to "プシー（プサイ）（Ψ）",
        "ω" to "オメガ（Ω）")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greek_character)

//        画面初期アクセス時のアルファベット設定
        questionGreekCharacter = randomGreek()
        settingQuestion(questionGreekCharacter)


//       次の問題
        val nextButton = findViewById(R.id.nextButton) as Button
        nextButton.setOnClickListener {
            questionGreekCharacter = randomGreek()
            settingQuestion(questionGreekCharacter)
            greekAnswer.text = ""
        }

//        こたえ
        val checkButton = findViewById(R.id.checkButton) as Button
        checkButton.setOnClickListener {
            greekAnswer.text = words[questionGreekCharacter]
        }
    }

    //    ランダムのギリシア文字を求める
    private fun randomGreek(): String {
        return words.keys.random()
    }
    //    問題欄にアルファベットをセットする
    private fun settingQuestion(word: String) {
        greekCharacter.text = word
    }
}
