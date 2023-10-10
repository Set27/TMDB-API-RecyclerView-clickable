package com.cronocode.moviecatalog.services

import com.cronocode.moviecatalog.models.Movie
import com.cronocode.moviecatalog.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApiInterface {

    @GET("/3/movie/popular?api_key=203fcb021461fe378c897fcf2e19fcb0")
    fun getMovieList(): Call<MovieResponse>

    @GET("/3/movie/{movie_id}?api_key=203fcb021461fe378c897fcf2e19fcb0")
    fun getMovieDetails(@Path("movie_id") movieId: String): Call<Movie>
}