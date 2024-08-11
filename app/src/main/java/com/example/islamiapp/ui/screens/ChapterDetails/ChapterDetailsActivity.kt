package com.example.islamiapp.ui.screens.ChapterDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.islamiapp.R
import com.example.islamiapp.databinding.ChapterDetailsActivityBinding
import java.io.BufferedReader
import java.io.InputStreamReader

class ChapterDetailsActivity : AppCompatActivity() {
    companion object {
        const val FILE_NAME = "file_name"
        const val SURA_NAME = "sura_name"
    }
    private lateinit var fileName: String
    private lateinit var suraName: String
    private lateinit var binding : ChapterDetailsActivityBinding
    private var chapterContent = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chapter_details_activity)
        fileName = intent.getStringExtra(FILE_NAME)!!
        suraName = intent.getStringExtra(SURA_NAME)!!
        readFile()
        binding!!.chapterContentTv.text = chapterContent
    }

    private fun readFile() {
        val reader = BufferedReader(
            InputStreamReader(assets.open("quran/$fileName"), "UTF-8")
        )
        var mLine: String?
        var verseNumber = 1
        mLine = reader.readLine()
        while (mLine != null) {
            chapterContent += mLine + "{${verseNumber}}"
            mLine = reader.readLine()
            verseNumber++
    }
}
}