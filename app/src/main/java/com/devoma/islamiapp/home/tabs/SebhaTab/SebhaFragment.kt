package com.devoma.islamiapp.home.tabs.SebhaTab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.RotateAnimation
import com.devoma.islamiapp.R
import com.devoma.islamiapp.databinding.FragmentSebhaBinding


class SebhaFragment : Fragment() {
    private var currentRotation = 0f
    var courrantZekrIndex = 0
    var count = 0
     var zekrList = listOf("الحمد الله","سبحان الله","الله اكبر")
    lateinit var viewBinding: FragmentSebhaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding = FragmentSebhaBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.sebhaImv.setOnClickListener {
            count++
            if (count>33){
                count = 1
                courrantZekrIndex = (courrantZekrIndex+1) % zekrList.size
                updataZekr()
            }
            viewBinding.zekrCount.text = count.toString()
            rotsteImage()
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