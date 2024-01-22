package com.example.firstapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firstapp.databinding.ActivityCameraBinding
import org.opencv.android.*
import org.opencv.core.*
import java.util.*

class Camera : AppCompatActivity() {




    companion object {
        private const val CAMERA_PERMISSION_REQUEST = 1001
        private const val TAG = "Camera"
    }
    private val binding by lazy {

        ActivityCameraBinding.inflate(layoutInflater)

    }



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        init()


    }

    private fun init() = binding.apply {
        val intent = Intent(this@Camera, FaceActivity::class.java)

        lunetteBleu.setOnClickListener {
            intent.putExtra("source", "sample1")
            startActivity(intent)
        }

        lunetteBlack.setOnClickListener {
            intent.putExtra("source", "black")
            startActivity(intent)
        }


    }

}