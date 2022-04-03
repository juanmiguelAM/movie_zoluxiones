package com.mancajima.movie_zoluxiones.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mancajima.movie_zoluxiones.R
import com.mancajima.movie_zoluxiones.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*var actionBar = supportActionBar
        if(actionBar != null){
            actionBar.setHomeAsUpIndicator(R.drawable.ic_exit)
            actionBar.setDisplayHomeAsUpEnabled(true)
        }*/

        binding.imvTest.setOnClickListener {
            startActivity(Intent(this, MovieDetail::class.java))
        }


    }
}