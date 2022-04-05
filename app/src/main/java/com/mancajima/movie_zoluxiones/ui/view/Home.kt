package com.mancajima.movie_zoluxiones.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.mancajima.movie_zoluxiones.R
import com.mancajima.movie_zoluxiones.databinding.ActivityHomeBinding
import com.mancajima.movie_zoluxiones.ui.view.adapter.MovieListAdapter
import com.mancajima.movie_zoluxiones.ui.viewmodel.MovieResponseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private var page_now:Int = 1
    private var total_pages:Int=0

    private val movieResponseViewModel: MovieResponseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movieResponseViewModel.movieResponse.observe(this, Observer {
            if(it.isNotEmpty()){
                val movieListAdapter = MovieListAdapter(this, it[0].results?: emptyList())
                val gridLayoutManager = GridLayoutManager(this, 2)
                total_pages = it[0].total_pages.toInt()
                binding.tvPage.setText(it[0].page+" / "+it[0].total_pages)

                binding.rvMoviesList.layoutManager = gridLayoutManager
                binding.rvMoviesList.setHasFixedSize(true)
                binding.rvMoviesList.adapter = movieListAdapter

                if(it[0].total_pages.toInt()==it[0].page.toInt()){
                    Toast.makeText(this, "Hey!, the data show is last search storage in local.", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Ups!, no get data of Network or Database.", Toast.LENGTH_SHORT).show()
            }

        })

        movieResponseViewModel.isLoading.observe(this, Observer {
            binding.lyIndicador.isVisible = it
        })

        //movieResponseViewModel.getMovieListResponse(page_now)
        movieResponseViewModel.getMovieListResponseV2(page_now)

        binding.lyRight.setOnClickListener {
            if(total_pages>0 && page_now<total_pages){
                page_now++
                movieResponseViewModel.getMovieListResponseV2(page_now)
            }else{
                Toast.makeText(this, "Ups!, last page.", Toast.LENGTH_SHORT).show()
            }
        }

        binding.lyLeft.setOnClickListener {
            if(page_now>1){
                page_now--
                movieResponseViewModel.getMovieListResponseV2(page_now)
            }else{
                Toast.makeText(this, "Ups!, firts page.", Toast.LENGTH_SHORT).show()
            }
        }

        binding.lyHomeTab.setOnClickListener {
            page_now = 1
            movieResponseViewModel.getMovieListResponseV2(page_now)
        }

        binding.lySearchTab.setOnClickListener {
            Toast.makeText(this, "Ups!, option in progress of development.", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}