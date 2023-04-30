package edu.vt.cs5254.fancygallery

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){

    private val photoRepository = PhotoRepository()

    private val _galleryItems: MutableStateFlow<List<GalleryItem>> = MutableStateFlow(emptyList())
    val galleryItems = _galleryItems.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                val items = photoRepository.fetchPhotos(99)
                Log.d("GalleryVM!!!", "Items received: $items")
                _galleryItems.value = items
            }
            catch(e : Exception){
                Log.e("GalleryVM!!!", "Failed to fetch gallery items", e)
            }
        }
    }

    fun reloadGalleryItems() {
        viewModelScope.launch {
            try {
                _galleryItems.value = emptyList()
                val items = photoRepository.fetchPhotos(99)
                _galleryItems.value = items
            }
            catch(e : Exception){
                Log.e("GalleryVM!!!", "Failed to fetch gallery items", e)
            }
        }
    }
}