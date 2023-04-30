package edu.vt.cs5254.fancygallery

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.request.CachePolicy
import edu.vt.cs5254.fancygallery.databinding.ListItemGalleryBinding

class GalleryItemAdapter(private val galleryItems: List<GalleryItem>,
                        private val onItemClicked: (Uri) -> Unit
                         ) : RecyclerView.Adapter<GalleryItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryItemHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemGalleryBinding.inflate(inflater, parent, false)
        return GalleryItemHolder(binding)
    }

    override fun getItemCount(): Int {
        return galleryItems.size
    }

    override fun onBindViewHolder(holder: GalleryItemHolder, position: Int) {
        holder.bind(galleryItems[position], onItemClicked)
    }

}

class GalleryItemHolder(private val binding: ListItemGalleryBinding) : RecyclerView.ViewHolder(binding.root){

    lateinit var boundGalleryItem : GalleryItem
        private set
    fun bind(galleryItem: GalleryItem,
             onItemClicked:(Uri) -> Unit
    ) {
        boundGalleryItem = galleryItem
        binding.itemImageView.load(galleryItem.url) {
            placeholder(R.drawable.ic_placeholder)
            diskCachePolicy(CachePolicy.DISABLED)
        }

        binding.root.setOnClickListener {
            onItemClicked(galleryItem.photoPageUri)
        }
    }

}
