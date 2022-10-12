package com.example.peenector.presentation.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.peenector.MainActivity
import com.example.peenector.databinding.ActivitySigninBinding

class SigninActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySigninBinding
    private var classOf: String? = null
    private var password: String? = null
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
            startForResult.launch(intent)
        }
    }

     val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            resultLaunchSignUp(result)
        }

    private fun resultLaunchSignUp(result: ActivityResult) {
        if (result.resultCode == RESULT_OK) {
            result.data?.let {
                //result.data가 null이면 let함수가 실행되지 않음
                classOf = it.getStringExtra("classOf")
                password = it.getStringExtra("passWord")
                binding.signinEdtClassof.setText(classOf)
                binding.signinEdtPassword.setText(password)
            }
        }
    }


    private fun clickLogin() {
        binding.signinBtnLogin.setOnClickListener {
            if (binding.signinEdtClassof.text.toString() == classOf && binding.signinEdtPassword.text.toString() == password) {
                Toast.makeText(this, "로그인에 성공했습니다.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "회원가입이랑 정보가 다릅니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }

}