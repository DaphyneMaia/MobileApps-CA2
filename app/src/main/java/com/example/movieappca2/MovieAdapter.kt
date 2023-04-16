package com.example.movieappca2

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.time.Duration
import java.util.Date
import java.util.Locale
import java.util.Random

class MovieAdapter(private var moviesCatalog: Array<MoviesCatalog>, private val onClick: (MoviesCatalog) -> Unit): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return moviesCatalog.size
    }

    @SuppressLint("SetTextI18n", "NewApi")
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        val movieLibrary = moviesCatalog[position]
        holder.bind(movieLibrary)
        holder.itemView.setOnClickListener {
            onClick(movieLibrary)
        }

        var imgUrl = moviesCatalog[position].movieImage
        Picasso.get()
            .load(imgUrl).into(holder.movieImage)
        var movieTitle = holder.itemView.findViewById<TextView>(R.id.movieTitle)
        movieTitle.text = moviesCatalog[position].movieTitle
        var movieClass = moviesCatalog[position].movieClass
        Picasso.get()
            .load(movieClass).into(holder.movieClass)
        var starring = holder.itemView.findViewById<TextView>(R.id.starring)
        starring.text = moviesCatalog[position].movieStarring


        var runningTime = holder.itemView.findViewById<TextView>(R.id.running_time_mins)
        runningTime.text = "Running time: " + moviesCatalog[position].getMovieDurationInHoursAndMinutes()
        var movieDesc = holder.itemView.findViewById<TextView>(R.id.movieDesc)
        movieDesc.text = moviesCatalog[position].movieDesc
        var remainingSeats = holder.itemView.findViewById<TextView>(R.id.seatsRemaining)
        remainingSeats.text = "Remaining seats: " + moviesCatalog[position].seatsRemaining
        var copyright = holder.itemView.findViewById<TextView>(R.id.copyright)
        copyright.text = "Informations taken from: https://www.myvue.com"

    }

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var movieImage: ImageView
        private var movieTitle: TextView
        var movieClass: ImageView
        private var movieStarring: TextView
        private var movieDesc: TextView
        private var copyright: TextView

        init {
            // Define click listener for the ViewHolder's View
            movieImage = view.findViewById(R.id.image)
            movieTitle = view.findViewById(R.id.movieTitle)
            movieClass = view.findViewById(R.id.movieClass)
            movieStarring = view.findViewById(R.id.starring)
            movieDesc = view.findViewById(R.id.movieDesc)
            copyright = view.findViewById(R.id.movieDesc)

        }
        fun bind(movieLibrary: MoviesCatalog) {

            Picasso.get()
                .load(movieLibrary.movieImage)
                .into(movieImage)

            movieTitle.text = movieLibrary.movieTitle

        }
    }
}