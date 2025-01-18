package com.devoma.islamiapp.home.tabs.QuranTab

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.devoma.islamiapp.databinding.ActivityChapterDetailsBinding
import com.devoma.islamiapp.model.AppConstant
import com.devoma.islamiapp.model.Chapter
import java.io.IOException

class ChapterDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChapterDetailsBinding
    var chapter: Chapter? = null
    lateinit var adapter: VersesAdapter
    lateinit var versesList: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChapterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        setSupportActionBar(binding.toolbar)

        // Enable the Up button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = chapter?.nameEN ?: "Chapter Details"
    }

    private fun init() {
        chapter = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(AppConstant.Extra.EXTRA_CHAPTER, Chapter::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(AppConstant.Extra.EXTRA_CHAPTER)
        }

        if (chapter == null) {
            // Handle the case where chapter is null, e.g., show an error message or finish the activity
            finish()
            return
        }

        readChapterQuran(chapter!!.INDEX)
        initRecyvlerViewContent()
        binding.tvSourahEn.text = chapter?.nameEN
        binding.content.sourahTitelAr.text = chapter?.nameAr

    }

    private fun initRecyvlerViewContent() {
        adapter = VersesAdapter(versesList)
        binding.content.sourahContent.layoutManager = LinearLayoutManager(this)
        binding.content.sourahContent.adapter = adapter
    }

    fun readChapterQuran(chapterIndex: Int) {
        try {
            var content = assets.open("Quran/${chapterIndex+1}.txt").bufferedReader().use { it.readText() }
            versesList = content.trim().split("\n")
        } catch (e: IOException) {
            // Handle the error, e.g., show an error message or log the error
            e.printStackTrace()
            versesList = emptyList() // or handle it in a way that makes sense for your app
        }
    }
}