package com.devoma.islamiapp.home.tabs.RadioTab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devoma.islamiapp.databinding.FragmentRadioBinding

class RadioFragment : Fragment() {

    lateinit var viewBinding: FragmentRadioBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding = FragmentRadioBinding.inflate(inflater, container, false)
        return viewBinding.root
    }
}



