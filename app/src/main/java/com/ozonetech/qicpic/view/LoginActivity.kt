package com.ozonetech.qicpic.view

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ozonetech.qicpic.R
import com.ozonetech.qicpic.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var input_mobile: EditText
    lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_login)

    }



    // Checking if the input in form is valid
    fun validateInput(): Boolean {
        if (binding.inputMobile.text.toString() == "") {
            binding.inputMobile.error = "Please Enter Mobile Number"
            return false
        }

        // checking the proper email format
        if (!isMobileNoValid(binding.inputMobile.text.toString())) {
            binding.inputMobile.error = "Please Enter Valid Mobile Number"
            return false
        }


        return true
    }

    fun isMobileNoValid(mobileNo: String?): Boolean {
        return mobileNo?.length == 10
    }


    fun performLogin(v: View) {
        if (validateInput()) {

            val mobileNo = binding.inputMobile!!.text.toString()

            //Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, OTPActivity::class.java)
            startActivity(intent)
            // Here you can call you API
        }
    }

}