package com.example.monoplug.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.monoplug.*
import com.example.monoplug.activity.AuthActivity
import com.example.monoplug.activity.HomeActivity
import com.example.monoplug.databinding.FragmentLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginFragment : Fragment(R.layout.fragment_login) {
    lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvDontHaveAnAccount.setOnClickListener {
            findNavController().navigate(R.id.chooseOptionFragment)
        }

        binding.tvForgotPass.setOnClickListener {
            findNavController().navigate(R.id.forgotPasswordFragment)
        }

        binding.btnLogin.root.setOnClickListener {

            var intent = Intent(requireActivity(),HomeActivity::class.java)
            (requireActivity() as AuthActivity).startActivity(intent)
            requireActivity().finish()
          //  loginUser()
        }
    }

    private fun loginUser() {

        val email = binding.etEmail.et.text.toString()
        val password = binding.etPassword.et.text.toString()

        val loginModel = LoginModel(email,password)
        var call  : Call<UserResponse> = RetrofitInstance.instance.loginUser(loginModel)

            call.enqueue(object : Callback<UserResponse> {
                override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                     if(response.isSuccessful) {
                         Log.d("TAGF1", response.message().toString())
                         Toast.makeText(requireContext(), "Login Successfully", Toast.LENGTH_SHORT).show()

                        var intent = Intent(requireActivity(), HomeActivity::class.java)
                        (requireActivity() as AuthActivity).startActivity(intent)
                        requireActivity().finish()

                    } else {
                        Toast.makeText(requireContext(), response.body().toString(), Toast.LENGTH_SHORT).show()
                        Log.d("TAGF2","$response")
                    }
                }
                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                    Toast.makeText(requireContext(), t.localizedMessage, Toast.LENGTH_SHORT).show()
                    Log.d("TAGF11","$t")
                }
            })
    }
}