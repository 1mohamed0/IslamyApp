package com.devoma.islamiapp.home.tabs.HadithTab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.devoma.islamiapp.CarouselSpacingItemDecoration
import com.devoma.islamiapp.R
import com.devoma.islamiapp.databinding.FragmentHadithBinding
import com.devoma.islamiapp.model.Hadeth
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.CarouselStrategy
import com.google.android.material.carousel.HeroCarouselStrategy


class HadithFragment : Fragment() {
    lateinit var viewBinding: FragmentHadithBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding = FragmentHadithBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    val hadethList: MutableList<Hadeth> = mutableListOf()

    lateinit var adapter: HadethAdapter
    lateinit var layoutManager: CarouselLayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        readAhadethFile()
        initeHadethRecycler()
    }

    private fun initeHadethRecycler() {
        adapter = HadethAdapter(hadethList)
        layoutManager = CarouselLayoutManager(
            HeroCarouselStrategy(), RecyclerView.HORIZONTAL
        )

        layoutManager.carouselAlignment = CarouselLayoutManager.ALIGNMENT_CENTER
        viewBinding.hadethRv.adapter = adapter
        viewBinding.hadethRv.layoutManager = layoutManager

        // Add spacing between items
        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.carousel_spacing)
        viewBinding.hadethRv.addItemDecoration(CarouselSpacingItemDecoration(spacingInPixels))

        // Prevent overscrolling
        viewBinding.hadethRv.setPadding(spacingInPixels, 0, spacingInPixels, 0)
        viewBinding.hadethRv.clipToPadding = false

        // Enable page-by-page scrolling
        val pagerSnapHelper = PagerSnapHelper()
        pagerSnapHelper.attachToRecyclerView(viewBinding.hadethRv)
    }

    fun readAhadethFile() {
        val fileContent =
            activity?.assets?.open("Hadith/ahadeth.txt")?.bufferedReader().use { it?.readText() }
        if (fileContent == null) return
        val hadethLineList = fileContent.trim().split("#")
        hadethLineList.forEach { singelHadeth ->
            val lines = singelHadeth.trim().split("\n")
            val title = lines[0].trim()
            val content = lines.takeLast(lines.size - 1).joinToString("\n")
            val hadeth = Hadeth(title, content)
            hadethList.add(hadeth)
        }
    }
}