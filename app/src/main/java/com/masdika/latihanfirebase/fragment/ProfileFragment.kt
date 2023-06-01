package com.masdika.latihanfirebase.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.masdika.latihanfirebase.R
import com.masdika.latihanfirebase.activity.LoginActivity
import com.masdika.latihanfirebase.databinding.FragmentProfileBinding
import com.squareup.picasso.Picasso

@Suppress("DEPRECATION")
class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private val auth = FirebaseAuth.getInstance()
    private val user = auth.currentUser

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

        binding.btnLogOut.setOnClickListener {
            FirebaseLogout()
        }

        return binding.root
    }

    private fun FirebaseLogout() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        val googleSignInClient = context?.let { GoogleSignIn.getClient(it, gso) }
        auth.signOut()
        googleSignInClient?.signOut()

        val intent = Intent(context, LoginActivity::class.java)
        startActivity(intent)
        activity?.finish()
    }

}