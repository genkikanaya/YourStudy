package com.example.kanayagenki.yourstudy

import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
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
        "V" to "ブイ（ウ”ィ）",
        "W" to "ダブリュ",
        "X" to "エックス",
        "Y" to "ワイ",
        "Z" to "ゼット(ズィー）")

    private lateinit var soundPool: SoundPool
    private var soundA = 0
    private var soundB = 0
    private var soundC = 0
    private var soundD = 0
    private var soundE = 0
    private var soundF = 0
    private var soundG = 0
    private var soundH = 0
    private var soundI = 0
    private var soundJ = 0
    private var soundK = 0
    private var soundL = 0
    private var soundM = 0
    private var soundN = 0
    private var soundO = 0
    private var soundP = 0
    private var soundQ = 0
    private var soundR = 0
    private var soundS = 0
    private var soundT = 0
    private var soundU = 0
    private var soundV = 0
    private var soundW = 0
    private var soundX = 0
    private var soundY = 0
    private var soundZ = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_english)

//        音声ファイルのローディング
        soundPool =
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                @Suppress("DEPRECATION")
                SoundPool(2, AudioManager.STREAM_MUSIC, 0)
            } else {
                val audioAttributes = AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANT)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                    .build()
                SoundPool.Builder()
                    .setMaxStreams(1)
                    .setAudioAttributes(audioAttributes)
                    .build()
            }
//        TODO
//        loadを一括でやる必要はあるか？？？
        soundA = soundPool.load(this, R.raw.alphabet02_a_01, 1)
        soundB = soundPool.load(this, R.raw.alphabet02_b_01, 1)
        soundC = soundPool.load(this, R.raw.alphabet02_c_01, 1)
        soundD = soundPool.load(this, R.raw.alphabet02_d_01, 1)
        soundE = soundPool.load(this, R.raw.alphabet02_e_01, 1)
        soundF = soundPool.load(this, R.raw.alphabet02_f_01, 1)
        soundG = soundPool.load(this, R.raw.alphabet02_g_01, 1)
        soundH = soundPool.load(this, R.raw.alphabet02_h_01, 1)
        soundI = soundPool.load(this, R.raw.alphabet02_i_01, 1)
        soundJ = soundPool.load(this, R.raw.alphabet02_j_01, 1)
        soundK = soundPool.load(this, R.raw.alphabet02_k_01, 1)
        soundL = soundPool.load(this, R.raw.alphabet02_l_01, 1)
        soundM = soundPool.load(this, R.raw.alphabet02_m_01, 1)
        soundN = soundPool.load(this, R.raw.alphabet02_n_01, 1)
        soundO = soundPool.load(this, R.raw.alphabet02_o_01, 1)
        soundP = soundPool.load(this, R.raw.alphabet02_p_01, 1)
        soundQ = soundPool.load(this, R.raw.alphabet02_q_01, 1)
        soundR = soundPool.load(this, R.raw.alphabet02_r_01, 1)
        soundS = soundPool.load(this, R.raw.alphabet02_s_01, 1)
        soundT = soundPool.load(this, R.raw.alphabet02_t_01, 1)
        soundU = soundPool.load(this, R.raw.alphabet02_u_01, 1)
        soundV = soundPool.load(this, R.raw.alphabet02_v_01, 1)
        soundW = soundPool.load(this, R.raw.alphabet02_w_01, 1)
        soundX = soundPool.load(this, R.raw.alphabet02_x_01, 1)
        soundY = soundPool.load(this, R.raw.alphabet02_y_01, 1)
        soundZ = soundPool.load(this, R.raw.alphabet02_z_01, 1)
//        ロードが終わったかの確認
        soundPool.setOnLoadCompleteListener { soundPool, sampleId, status ->
            Log.d("debug", "sampleId=$sampleId")
            Log.d("debug", "status=$status")
        }


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
//            soundPool.play(soundA, 1.0f, 1.0f, 0, 0, 1.0f)
            when (questionAlphabet) {
                "A" -> soundPool.play(soundA, 1.0f, 1.0f, 0, 0, 1.0f)
                "B" -> soundPool.play(soundB, 1.0f, 1.0f, 0, 0, 1.0f)
                "C" -> soundPool.play(soundC, 1.0f, 1.0f, 0, 0, 1.0f)
                "D" -> soundPool.play(soundD, 1.0f, 1.0f, 0, 0, 1.0f)
                "E" -> soundPool.play(soundE, 1.0f, 1.0f, 0, 0, 1.0f)
                "F" -> soundPool.play(soundF, 1.0f, 1.0f, 0, 0, 1.0f)
                "G" -> soundPool.play(soundG, 1.0f, 1.0f, 0, 0, 1.0f)
                "H" -> soundPool.play(soundH, 1.0f, 1.0f, 0, 0, 1.0f)
                "I" -> soundPool.play(soundI, 1.0f, 1.0f, 0, 0, 1.0f)
                "J" -> soundPool.play(soundJ, 1.0f, 1.0f, 0, 0, 1.0f)
                "K" -> soundPool.play(soundK, 1.0f, 1.0f, 0, 0, 1.0f)
                "L" -> soundPool.play(soundL, 1.0f, 1.0f, 0, 0, 1.0f)
                "M" -> soundPool.play(soundM, 1.0f, 1.0f, 0, 0, 1.0f)
                "N" -> soundPool.play(soundN, 1.0f, 1.0f, 0, 0, 1.0f)
                "O" -> soundPool.play(soundO, 1.0f, 1.0f, 0, 0, 1.0f)
                "P" -> soundPool.play(soundP, 1.0f, 1.0f, 0, 0, 1.0f)
                "Q" -> soundPool.play(soundQ, 1.0f, 1.0f, 0, 0, 1.0f)
                "R" -> soundPool.play(soundR, 1.0f, 1.0f, 0, 0, 1.0f)
                "S" -> soundPool.play(soundS, 1.0f, 1.0f, 0, 0, 1.0f)
                "T" -> soundPool.play(soundT, 1.0f, 1.0f, 0, 0, 1.0f)
                "U" -> soundPool.play(soundU, 1.0f, 1.0f, 0, 0, 1.0f)
                "V" -> soundPool.play(soundV, 1.0f, 1.0f, 0, 0, 1.0f)
                "W" -> soundPool.play(soundW, 1.0f, 1.0f, 0, 0, 1.0f)
                "X" -> soundPool.play(soundX, 1.0f, 1.0f, 0, 0, 1.0f)
                "Y" -> soundPool.play(soundY, 1.0f, 1.0f, 0, 0, 1.0f)
                "Z" -> soundPool.play(soundZ, 1.0f, 1.0f, 0, 0, 1.0f)
            }
        }
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
