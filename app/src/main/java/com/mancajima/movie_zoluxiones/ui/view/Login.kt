package com.mancajima.movie_zoluxiones.ui.view

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.mancajima.movie_zoluxiones.R
import com.mancajima.movie_zoluxiones.databinding.ActivityLoginBinding
import com.mancajima.movie_zoluxiones.ui.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Login : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    private val userViewModel:UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userViewModel.onInsertUser("Admin", "Password*123", "Admin - Z movies")//User admin for default

        userViewModel.isLoading.observe(this, Observer {
            binding.lyIndicador.isVisible = it
            Log.i("LOGIN", ""+it)
        })

        userViewModel.isLoginUser.observe(this, Observer {
            if(it){
                this.clearFields()
                startActivity(Intent(this, Home::class.java), ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
            }else{
                this.clearFields()
                Toast.makeText(this, "Please, verify your user or password.", Toast.LENGTH_SHORT).show()
            }
        })

        binding.btnLogin.setOnClickListener {
            val user = binding.edtUser.text.trim().toString()
            val pw = binding.edtPassword.text.trim().toString()
            if(user.isNotEmpty() && pw.isNotEmpty()){
                userViewModel.getUserLogin(binding.edtUser.text.trim().toString(), binding.edtPassword.text.trim().toString())
            }else{
                Toast.makeText(this, "You must complete all fields (User/Password).", Toast.LENGTH_SHORT).show()
            }
        }

        binding.edtUser.requestFocus()
    }

    private fun clearFields(){
        binding.edtUser.setText("")
        binding.edtPassword.setText("")
        binding.edtUser.requestFocus()
    }
}