package com.masdika.latihanfirebase.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.masdika.latihanfirebase.databinding.FragmentInsertDataBinding

class InsertDataFragment : Fragment() {

    private var _binding: FragmentInsertDataBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInsertDataBinding.inflate(inflater, container, false)

        return binding.root
    }

}