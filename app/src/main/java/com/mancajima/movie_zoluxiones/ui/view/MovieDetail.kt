package com.mancajima.movie_zoluxiones.ui.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.mancajima.movie_zoluxiones.R
import com.mancajima.movie_zoluxiones.databinding.ActivityMovieDetailBinding

class MovieDetail : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Option in progress..", Snackbar.LENGTH_LONG)
                .setAction("Info", null).show()
        }

        var actionBar = supportActionBar
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

        val id = intent.getStringExtra("id")
        val title_ = intent.getStringExtra("title")
        val poster_path = intent.getStringExtra("poster_path")
        val vote_average = intent.getStringExtra("vote_average")
        val release_date = intent.getStringExtra("release_date")
        val overview = intent.getStringExtra("overview")
        val backdrop_path = intent.getStringExtra("backdrop_path")

        Glide.with(this).load(poster_path).diskCacheStrategy(DiskCacheStrategy.ALL).centerCrop().error(R.drawable.img_not_poster_error).into(binding.imvDetailMovie)
        binding.contentScrolling.tvTitleMovie?.setText(title_)
        binding.contentScrolling.tvVoteAverage?.setText(vote_average)
        binding.contentScrolling.tvOverviewMovie?.setText(overview)
        binding.contentScrolling.tvReleaseDate?.setText(release_date)
        binding.toolbarLayout.title = title_
        binding.contentScrolling.lyBackdrop?.isVisible = !backdrop_path.isNullOrEmpty()
        Glide.with(this).load(backdrop_path).centerCrop().into(binding.contentScrolling.itemImvBackdrop!!)

        binding.contentScrolling.rlTouchBackdrop?.setOnClickListener {
            val url_ = "https://www.youtube.com/results?search_query=trailer+"+title_?.lowercase()?.replace(" ", "+")
            Log.i("URL", url_)
            val webpage: Uri = Uri.parse(url_)
            val intent = Intent(Intent.ACTION_VIEW, webpage)
            /*if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }*/
            startActivity(intent)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}