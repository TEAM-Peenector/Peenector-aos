package com.example.peenector.presentation.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.peenector.MainActivity
import com.example.peenector.data.PennerctorClient
import com.example.peenector.data.remote.request.RequestLogin
import com.example.peenector.data.remote.response.ResponseLogin
import com.example.peenector.databinding.ActivitySigninBinding
import com.example.peenector.presentation.mypage.MypageActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SigninActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySigninBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClickSignUp()
        clickLogin()
    }

    private fun onClickSignUp() {
        binding.tvGotoSignup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }


    private fun clickLogin() {
        binding.signinBtnLogin.setOnClickListener {
            writeInitNetwork()
            finish()
        }
    }

    private fun writeInitNetwork() {
        val requestLogin = RequestLogin(
            schoolNumber = binding.signinEdtClassof.text.toString(),
            password = binding.signinEdtPassword.text.toString()
        )
        val call: Call<ResponseLogin> = PennerctorClient.loginService.postLogin(requestLogin)
        call.enqueue(object : Callback<ResponseLogin> {
            override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {
                if (response.isSuccessful) {
                    val data = response.body()?.data
                    Log.e("data", "${data?.teamNumber}")
                    Toast.makeText(this@SigninActivity, "로그인에 성공했습니다.", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@SigninActivity, MainActivity::class.java)
                    intent.putExtra("id", data?.teamNumber)
                    Intent(this@SigninActivity, MypageActivity::class.java).putExtra(
                        "id",
                        data?.teamNumber
                    )
                    startActivity(intent)
                    finish()
                } else {
                    Log.d("loginerror", "onResponse: ")
                }
            }

            override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                Log.e("NetWorkTest", "error: $t")
            }
        })
    }

}