package com.devoma.islamiapp.home.tabs.SebhaTab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devoma.islamiapp.R
import com.devoma.islamiapp.databinding.FragmentSebhaBinding


class SebhaFragment : Fragment() {
    private var currentRotation = 0f
    var courrantZekrIndex = 0
    var count = 0
    lateinit var zekrList: MutableList<String>
    lateinit var viewBinding: FragmentSebhaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        viewBinding = FragmentSebhaBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        zekrList = resources.getStringArray(R.array.azkarName).toMutableList()
        viewBinding.zekrName.text = zekrList[courrantZekrIndex]
        viewBinding.zekrCount.text = "$count"
        viewBinding.sebhaImv.setOnClickListener {
            rotsteImage()
            if (count < 33) {
                count++
            } else {
                count = 0
                courrantZekrIndex =
                    if (courrantZekrIndex < zekrList.size - 1) ++courrantZekrIndex else 0
                viewBinding.zekrName.text = zekrList[courrantZekrIndex]
            }
            viewBinding.zekrCount.text = "$count"
        }
    }

    private fun rotsteImage() {
        currentRotation += 10f
        viewBinding.sebhaImv.rotation = currentRotation
    }

    private fun updataZekr() {
        viewBinding.zekrName.text = zekrList[courrantZekrIndex]
    }
}