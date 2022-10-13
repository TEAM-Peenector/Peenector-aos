package com.example.peenector.presentation.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.peenector.data.PennerctorClient
import com.example.peenector.data.remote.request.RequestSignUp
import com.example.peenector.data.remote.response.ResponseSignUp
import com.example.peenector.databinding.ActivitySignUpBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    //    private val autoChecking: AutoChecking = AutoChecking()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickSignUp()
    }

    private fun clickSignUp() {
        binding.signupBtnLogin.setOnClickListener {
            writeInitNetwork()
            finish()
        }
    }

    private fun passingIntent() {
        val intent = Intent(this, SigninActivity::class.java)
        intent.putExtra("classOf", binding.signupEdtClassof.text.toString())
        intent.putExtra("passWord", binding.signupEdtPassword.text.toString())
        setResult(Activity.RESULT_OK, intent)
    }

    private fun writeInitNetwork() {
        val requestSignUp = RequestSignUp(
            contact = binding.signupEdtPhonenum.text.toString(),
            email = binding.signupEdtEmail.text.toString(),
            name = binding.signupEdtName.text.toString(),
            schoolNumber = binding.signupEdtClassof.text.toString(),
            password = binding.signupEdtPassword.text.toString()
        )
        val call: Call<ResponseSignUp> = PennerctorClient.signUpService.postSignUp(requestSignUp)
        call.enqueue(object : Callback<ResponseSignUp> {
            override fun onResponse(
                call: Call<ResponseSignUp>,
                response: Response<ResponseSignUp>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.data
                    passingIntent()
                }
            }

            override fun onFailure(call: Call<ResponseSignUp>, t: Throwable) {
                Log.e("SignUp 서버연결", "onFailure: $t", )
            }
        })
    }

}

