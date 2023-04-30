package edu.vt.cs5254.fancygallery.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val API_KEY = "2867e9d851e77d1b901b9dd9a2d51d82"

interface FlickrApi {
    @GET("services/rest/?method=flickr.interestingness.getList" +
            "&api_key=$API_KEY" +
            "&format=json" +
            "&nojsoncallback=1" +
            "&extras=url_s,geo" )
    suspend fun fetchPhotos(@Query("per_page") per_page:Int): FlickrResponse
}
