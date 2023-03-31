package com.example.lesson2_month6

import android.annotation.SuppressLint
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lesson2_month6.databinding.GalleryItemBinding

class GalleryAdapter(private val onCLick: (uri: Uri) -> Unit) : RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {

    private var galleryList = arrayListOf<Uri>()

    val selectedList = ArrayList<Uri>()

    inner class GalleryViewHolder(private var binding: GalleryItemBinding) : ViewHolder(binding.root){
        @SuppressLint("ResourceAsColor")
        fun bind(uri: Uri) {
            onCLick(uri)
            binding.nonSelectedIv.setImageURI(uri)
            itemView.setOnClickListener{
                if (!binding.selectedIv.isVisible) {
                    binding.selectedIv.isVisible = true
                    selectedList.add(uri)
                } else {
                    binding.selectedIv.isVisible = false
                    selectedList.remove(uri)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        return GalleryViewHolder(GalleryItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.bind(galleryList[position])
    }

    override fun getItemCount(): Int = galleryList.size

    @SuppressLint("NotifyDataSetChanged")
    fun addList(uri: Uri) {
        galleryList.addAll(0, listOf(uri))
        notifyDataSetChanged()
    }
}



