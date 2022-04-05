package com.mancajima.movie_zoluxiones.ui.view.adapter

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.mancajima.movie_zoluxiones.R
import com.mancajima.movie_zoluxiones.domain.model.Movie
import com.mancajima.movie_zoluxiones.ui.view.MovieDetail
import android.util.Pair as UtilPair

class MovieListAdapter (private val context: Activity, private val dataSet:List<Movie>):RecyclerView.Adapter<MovieListAdapter.ViewHolder>(){

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val item_imv_cover:ImageView
        val item_tv_title:TextView
        init {
            item_imv_cover = view.findViewById(R.id.item_imv_cover)
            item_tv_title = view.findViewById(R.id.item_tv_title)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie_main, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]
        val poster_path:String = "https://image.tmdb.org/t/p/w500"+item.poster_path
        var backdrop_path:String = ""
        if(!item.backdrop_path.isNullOrEmpty()){
            backdrop_path = "https://image.tmdb.org/t/p/w500"+item.backdrop_path
        }
        Glide.with(holder.item_imv_cover).load(poster_path).diskCacheStrategy(DiskCacheStrategy.ALL).centerCrop().error(R.drawable.img_not_poster_error).into(holder.item_imv_cover)
        holder.item_tv_title.isVisible = item.poster_path.isNullOrEmpty()

        holder.item_tv_title.setText(item.title)

        holder.item_imv_cover.setOnClickListener {
            val intent = Intent(context, MovieDetail::class.java)
            intent.putExtra("id", item.id)
            intent.putExtra("title", item.title)
            intent.putExtra("poster_path", poster_path)
            intent.putExtra("vote_average", item.vote_average)
            intent.putExtra("release_date", item.release_date)
            intent.putExtra("overview", item.overview)
            intent.putExtra("backdrop_path", backdrop_path)

            val optionsCompat =  ActivityOptions.makeSceneTransitionAnimation(
                context, UtilPair.create(holder.item_imv_cover, "imageTransition")
            )
            context.startActivity(intent, optionsCompat.toBundle())
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}