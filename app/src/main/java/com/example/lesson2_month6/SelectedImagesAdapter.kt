package com.example.lesson2_month6

import android.annotation.SuppressLint
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lesson2_month6.databinding.ItemSelectedBinding

class SelectedImagesAdapter : RecyclerView.Adapter<SelectedImagesAdapter.SelectedViewHolder>() {

    private var galleryList = arrayListOf<Uri>()

    inner class SelectedViewHolder(private var binding: ItemSelectedBinding) : ViewHolder(binding.root){
        fun bind(uri: Uri) {
            binding.imageSelectedRecycler.setImageURI(uri)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addImage(mainImage: ArrayList<Uri>) {
        galleryList = mainImage
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectedViewHolder {
        return SelectedViewHolder(ItemSelectedBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: SelectedViewHolder, position: Int) {
        holder.bind(galleryList[position])
    }

    override fun getItemCount(): Int = galleryList.size
}