package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.recycleview.databinding.ActivitySecondBinding


class MainActivity2 : AppCompatActivity(){
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val extras = intent.extras ?: return



        val titles = extras.getInt("Title")
        val details = extras.getInt("Detail")
        val images = extras.getInt("Image")
        binding.heading.text = Data.titles[titles]
        binding.description.text = Data.details[details]
        binding.imageView.setImageResource(Data.images[images])


    }

}