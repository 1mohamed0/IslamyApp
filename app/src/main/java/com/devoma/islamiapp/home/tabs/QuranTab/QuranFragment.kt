package com.devoma.islamiapp.home.tabs.QuranTab

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devoma.islamiapp.databinding.FragmentQuranBinding
import com.devoma.islamiapp.model.AppConstant


class QuranFragment : Fragment() {
    lateinit var viewBinding: FragmentQuranBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentQuranBinding.inflate(
            inflater,container,false
        )
        // Inflate the layout for this fragment
        return viewBinding.root
    }
    lateinit var adabter: quranAdabter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adabter = quranAdabter(chapters)
adabter.onItemClicks = quranAdabter.onItemClick { position, chapter ->
    val intent = Intent(activity, ChapterDetailsActivity::class.java)
    intent.putExtra(AppConstant.Extra.EXTRA_CHAPTER,chapter)
    startActivity(intent)

}
            viewBinding.verseContent.adapter = adabter
    }

    val chapters = AppConstant.getChapter()
}