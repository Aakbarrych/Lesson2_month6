package com.example.lesson2_month6

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson2_month6.databinding.ActivitySelectedBinding

@Suppress("UNCHECKED_CAST", "DEPRECATION")
class SelectedActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectedBinding

    private val adapter = SelectedImagesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        initListener()
    }

    private fun initView() {
        binding.rvSelectedImage.adapter = adapter
    }
    private fun initListener() {
        val uri = intent.getSerializableExtra(getString(R.string.data_image))
        if (uri != null) {
            adapter.addImage(uri as ArrayList<Uri>)
        }
    }
}