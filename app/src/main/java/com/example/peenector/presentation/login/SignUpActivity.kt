package com.example.peenector.presentation.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.peenector.databinding.ActivitySignUpBinding
import com.example.peenector.util.AutoChecking

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
//    private val autoChecking: AutoChecking = AutoChecking()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickSignUp()
    }

    private fun clickSignUp(){
        binding.signupBtnLogin.setOnClickListener {
            passingIntent()
            finish()
        }
    }

    private fun passingIntent(){
       val intent = Intent(this,SigninActivity::class.java)
        intent.putExtra("classOf",binding.signupEdtClassof.text.toString())
        intent.putExtra("passWord",binding.signupEdtPassword.text.toString())
        setResult(Activity.RESULT_OK,intent)
    }

}

