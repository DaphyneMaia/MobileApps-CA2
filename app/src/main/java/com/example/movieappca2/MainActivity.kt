package com.example.movieappca2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {

    @SuppressLint("SuspiciousIndentation", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val rangeOfSeats = IntRange(0, 15)
        val moviesArray = arrayOf(
                MoviesCatalog("JOHN WICK: CHAPTER 4","https://poster.gsc.com.my/2023/230222_JohnWickChapter4_big.jpg","https://www.myvue.com/-/media/system/certificates/certificates%20ireland/16.png", "John Wick (Keanu Reeves) uncovers a path to defeating The High Table. But before he can earn his freedom, Wick must face off against a new enemy with powerful alliances across the globe and forces that turn old friends into foes.", "Starring: Keanu Reeves, Donnie Yen, Bill Skarsgård", 169,Random.nextInt(rangeOfSeats)),
                MoviesCatalog("DUNGEONS & DRAGONS: HONOUR AMONG THIEVES", "https://static.metacritic.com/images/products/movies/9/87cafaef5b310285c38bbf8d9c3131ea.jpg", "https://www.myvue.com/-/media/system/certificates/certificates%20ireland/12a.png","A charming thief and a band of unlikely adventurers undertake an epic heist to retrieve a lost relic, but things go dangerously awry when they run afoul of the wrong people.", "Starring: Chris Pine, Michelle Rodriguez, Justice Smith, Regé-Jean Page, Sophia Lillis, Chloe Coleman, Daisy Head, Hugh Grant",134,Random.nextInt(rangeOfSeats)),
                MoviesCatalog("THE SUPER MARIO BROS. MOVIE", "https://www.universalpictures.ie/tl_files/content/movies/super_mario_bros/super-mario-bros_header-mobile.jpg","https://www.myvue.com/-/media/system/certificates/certificates%20ireland/pg.png", "A plumber named Mario travels through an underground labyrinth with his brother, Luigi, trying to save a captured princess.","Starring: Chris Pratt, Anya Taylor-Joy, Charlie Day, Jack Black, Seth Rogen",94,Random.nextInt(rangeOfSeats)),
                MoviesCatalog("SHAZAM! FURY OF THE GODS", "https://m.media-amazon.com/images/M/MV5BNzJlM2NmZTItOGQyYS00MmE2LTkwZGUtNDFkNmJmZjRjZjcxXkEyXkFqcGdeQXVyMTA3MDk2NDg2._V1_.jpg","https://www.myvue.com/-/media/system/certificates/certificates%20ireland/12a.png", "When the Daughters of Atlas, a vengeful trio of ancient gods, arrive on Earth in search of the magic stolen from them long ago, Billy - aka Shazam - and his family are thrust into a battle for their superpowers, their lives, and the fate of their world.", "Starring: Zachary Levi, Helen Mirren, Adam Brody, Lucy Liu, Grace Caroline Currey", 130,Random.nextInt(rangeOfSeats))
            )
        val movieAdapter = MovieAdapter(moviesArray){ chosenMovie ->
            val intent = Intent(this, MovieChoices::class.java)
            intent.putExtra("movies", chosenMovie)
            startActivity(intent)
        }
        recyclerView.adapter = movieAdapter
    }
}