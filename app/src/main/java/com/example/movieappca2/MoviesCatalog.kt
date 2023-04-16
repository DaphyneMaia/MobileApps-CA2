package com.example.movieappca2

import android.annotation.SuppressLint
import java.io.Serializable
import java.time.Duration
import java.util.Locale

data class MoviesCatalog(

    var id: Int,
    var movieTitle: String,
    var movieImage: String,
    var movieClass: String,
    var movieDesc: String,
    var movieStarring: String,
    var runningTimeMin: Int,
    var seatsRemaining: Int,
    var selectSeats: Int = 0

) : Serializable {

    @SuppressLint("NewApi")
    fun getMovieDurationInHoursAndMinutes(): String {
        val durationFilm = Duration.ofMinutes(this.runningTimeMin.toLong())
        val remainingMinutes = durationFilm.toMinutes() - durationFilm.toHours() * 60
        return String.format(
            Locale.forLanguageTag("en-IN"),
            "%dhrs %dmin",
            durationFilm.toHours(),
            remainingMinutes
        )
    }
}



