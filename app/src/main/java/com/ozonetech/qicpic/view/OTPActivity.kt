package com.ozonetech.qicpic.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.ozonetech.qicpic.R
import com.ozonetech.qicpic.databinding.ActivityOTPBinding

class OTPActivity : AppCompatActivity() {
    private lateinit var binding : ActivityOTPBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_o_t_p)
    }

    fun performOTPVerfication(view : View){
        if(validateInput()){
            val otp = binding.et1!!.text.toString() + binding.et2!!.text.toString() + binding.et3!!.text.toString() + binding.et4!!.text.toString()
            Toast.makeText(this, "otp : "+otp, Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun validateInput(): Boolean {
        if(binding.et1.text.toString() == ""){
            binding.et1.error = "Please enter OTP"
            return false
        }else  if(binding.et2.text.toString() == ""){
            binding.et2.error = "Please enter OTP"
            return false
        }else  if(binding.et3.text.toString() == ""){
            binding.et3.error = "Please enter OTP"
            return false
        }else  if(binding.et4.text.toString() == ""){
            binding.et4.error = "Please enter OTP"
            return false
        }else
            return true
    }
}