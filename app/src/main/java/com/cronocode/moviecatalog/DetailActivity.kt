package com.cronocode.moviecatalog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.cronocode.moviecatalog.models.Movie
import com.cronocode.moviecatalog.services.MovieApiInterface
import com.cronocode.moviecatalog.services.MovieApiService
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val movieId = intent.getStringExtra("movie")
        if (movieId != null) {
            getMovieDetails(movieId)
        }
    }

    private fun getMovieDetails(movieId: String) {
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieDetails(movieId).enqueue(object : Callback<Movie> {
            override fun onFailure(call: Call<Movie>, t: Throwable) {
                Log.e("JOPA", t.message.toString())
            }

            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                val movie = response.body()
                Log.e("JOPA", response.body().toString())
                val textView = findViewById<TextView>(R.id.textView4)
                textView.text = movie?.status
                val textView2 = findViewById<TextView>(R.id.textView5)
                textView2.text = movie?.budget.toString() + "$"
            }
        })
    }
}