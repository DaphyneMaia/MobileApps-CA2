package com.example.movieappca2

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.google.android.material.button.MaterialButton
import com.squareup.picasso.Picasso

class MovieChoices : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_choices)

        val movieLibrary: MoviesCatalog? = intent.getSerializableExtra("movies") as? MoviesCatalog
        if (movieLibrary != null) {
            cinemaMovieData(movieLibrary)
        } else {
            Log.e("MovieActivity", "Movie object is null")
        }
    }

    @SuppressLint("WrongViewCast", "SetTextI18n")
    fun cinemaMovieData(movieLibrary: MoviesCatalog) {

        val movieTitle: TextView = findViewById(R.id.movieTitle)
        val movieImage: ImageView = findViewById(R.id.image)
        val movieClass: ImageView = findViewById(R.id.movieClass)
        val movieDesc: TextView = findViewById(R.id.movieDesc)
        val movieStarring: TextView = findViewById(R.id.starring)
        val runningTimeMin: TextView = findViewById(R.id.running_time_mins)
        val seatsSelected: TextView = findViewById(R.id.selectSeats)
        //val remaingSeats: TextView = findViewById(R.id.seatsRemaining)
        val addButton= findViewById<Button>(R.id.addButton)
        val subButton = findViewById<Button>(R.id.subButton)
        val returnButton = findViewById<Button>(R.id.returnButton)

        Picasso.get()
            .load(movieLibrary.movieImage)
            .into(movieImage)

        movieTitle.text = movieLibrary.movieTitle
        movieStarring.text = movieLibrary.movieStarring

        Picasso.get()
            .load(movieLibrary.movieClass)
            .into(movieClass)

        movieDesc.text = movieLibrary.movieDesc
        runningTimeMin.text = "Running time: " + movieLibrary.getMovieDurationInHoursAndMinutes()
        movieDesc.text = movieLibrary.movieDesc
        seatsSelected.text = "Select seats: " + movieLibrary.selectSeats.toString()

        addButton.setOnClickListener {
            if(movieLibrary.selectSeats < movieLibrary.seatsRemaining) {
                seatsSelected.text = "Select seats: " + ++movieLibrary.selectSeats
               movieLibrary.seatsRemaining -= movieLibrary.selectSeats
            }
        }

        subButton.setOnClickListener {
            if (movieLibrary.selectSeats >= 1) {
                seatsSelected.text = "Select seats: " + --movieLibrary.selectSeats
                movieLibrary.seatsRemaining = ++movieLibrary.seatsRemaining
            }
        }

        returnButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("remaining", movieLibrary)
            startActivity(intent)
        }
    }
}