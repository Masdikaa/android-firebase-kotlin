package com.masdika.latihanfirebase.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.masdika.latihanfirebase.databinding.FragmentViewDataBinding

class ViewDataFragment : Fragment() {

    private var _binding: FragmentViewDataBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentViewDataBinding.inflate(inflater, container, false)



        return binding.root
    }

}