package com.example.lesson2_month6

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.lesson2_month6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val adapter = GalleryAdapter(this:: onSend)

    private val galleryList = arrayListOf<Uri>()

    private val loadImage =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                val image = it.data?.data
                if (image != null) {
                    adapter.addList(image)
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerview.adapter = adapter
        onClick()
    }

    private fun onClick() {
        binding.choosePhotoBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            intent.putExtra(Intent.ACTION_PICK, true)
            loadImage.launch(intent)
        }
    }

    private fun onSend(uri: Uri) {
        binding.sendBtn.setOnClickListener {
            galleryList.addAll(listOf(uri))
            Intent(this, SelectedActivity::class.java).apply {
                putExtra(KEY_IMAGE, adapter.selectedList)
                startActivity(this)
            }
        }
    }

    companion object {
        const val KEY_IMAGE = "image"
    }
}