package com.example.monoplug.fragment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.monoplug.R
import com.example.monoplug.RealPathUtil
import com.example.monoplug.RetrofitInstance
import com.example.monoplug.UserResponse
import com.example.monoplug.databinding.FragmentSignupBinding
import com.github.dhaval2404.imagepicker.ImagePicker
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File


class SignupFragment : Fragment() {

    lateinit var binding: FragmentSignupBinding

    lateinit var path: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_signup, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.floatingBtn.setOnClickListener {
            //  contract.launch("image/*")
            ImagePicker.with(this)
                .crop()                    //Crop image(Optional), Check Customization for more option
                .compress(1024)            //Final image size will be less than 1 MB(Optional)
                .maxResultSize(
                    1080,
                    1080
                )    //Final image resolution will be less than 1080 x 1080(Optional)
                .start()

        }

        binding.tvAlready.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
        }

        binding.tvTermCondition.setOnClickListener {
            findNavController().navigate(R.id.termsAndConditionsFragment)
        }
        binding.btnSignUp.root.setOnClickListener {
            //  findNavController().navigate(R.id.signupPopup)
            createUser()

        }
    }

    private fun createUser() {
        //user entered data
        val firstName = binding.etFirstName.et.text.toString()
        val lastName = binding.etLastName.et.text.toString()
        val email = binding.etEmail.et.text.toString()
        val password = binding.etPassword.et.text.toString()
        val confirmPassword = binding.etConfirmPassword.et.text.toString()


        if (firstName.isEmpty()) {
            Toast.makeText(context, "Enter Firstname", Toast.LENGTH_LONG).show()
        } else if (lastName.isEmpty()) {
            Toast.makeText(context, "Enter Lastname", Toast.LENGTH_LONG).show()
        } else if (email.isEmpty()) {
            Toast.makeText(context, "Enter Email", Toast.LENGTH_LONG).show()
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(context, "Enter valid email ", Toast.LENGTH_LONG).show()
        } else if (password.isEmpty()) {
            Toast.makeText(context, "Enter Password", Toast.LENGTH_LONG).show()
        } else if (password.length < 8) {
            Toast.makeText(context, "Password must be at least 8 characters", Toast.LENGTH_LONG)
                .show()
        } else if (!password.matches(".*[A-Z].*".toRegex())) {
            Toast.makeText(
                context,
                "Password must contain atleast one uppercase letter",
                Toast.LENGTH_LONG
            ).show()
        } else if (confirmPassword.isEmpty()) {
            Toast.makeText(context, "Enter ConfirmPassword", Toast.LENGTH_LONG).show()
        } else {
            val file = File(path)
            //
            Log.d("TAG", "path  :${path}")
            val requestFile: RequestBody =
                RequestBody.create("multipart/form-data".toMediaTypeOrNull(), file)

            val body = MultipartBody.Part.createFormData("image", file.name, requestFile)
            //
            Log.d("TAG", "body  :${body}")

          RetrofitInstance.instance.createUser(firstName, lastName, email, password, false, body)
               .enqueue(object : Callback<UserResponse> {
                    override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {

                        Toast.makeText(context,response.message().toString() , Toast.LENGTH_LONG).show()
                        Log.d("TAG", " response success :${response.message()}")
                        findNavController().navigate(R.id.signupPopup)
                    }

                    override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                        Toast.makeText(context, t.localizedMessage, Toast.LENGTH_LONG).show()
                        Log.d("TAG", " response success :${t.localizedMessage?.toString()}")
                    }
                })
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {

            //Image Uri will not be null for RESULT_OK
            val uri: Uri = data?.data!!
            var context: Context = requireContext()
            path = RealPathUtil.getRealPath(context, uri).toString()
            var bitmap: Bitmap = BitmapFactory.decodeFile(path)
            binding.ImgProfile.setImageBitmap(bitmap)
            Log.d("TAG", " image bitmap  :${bitmap.toString()}")

        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(requireContext(), ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireContext(), "Task Cancelled", Toast.LENGTH_SHORT).show()
        }
    }


}


