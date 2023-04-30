package edu.vt.cs5254.fancygallery.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import edu.vt.cs5254.fancygallery.GalleryItem

@JsonClass(generateAdapter = true)
data class PhotoResponse(
    @Json(name = "photo") val galleryItems: List<GalleryItem>
)
