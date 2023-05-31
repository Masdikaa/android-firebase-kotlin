package com.masdika.latihanfirebase.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.masdika.latihanfirebase.databinding.FragmentProfileBinding
import com.squareup.picasso.Picasso

@Suppress("DEPRECATION")
class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        val args = this.arguments
        val getDisplayName = args?.get("display_name")
        val getEmail = args?.get("email")
        val getImageProfile = args?.get("profile_image")

        binding.displayName.text = getDisplayName.toString()
        binding.accountEmail.text = getEmail.toString()
        Picasso.get().load(getImageProfile.toString()).into(binding.profilePic)

        return binding.root
    }

}