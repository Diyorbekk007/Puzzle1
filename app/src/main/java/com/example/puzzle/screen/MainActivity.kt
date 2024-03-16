package com.example.puzzle.screen

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.puzzle.R
import com.example.puzzle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        try {
            val buttonOpenActivity1: Button = binding.playButton4x4
            buttonOpenActivity1.setOnClickListener {
                Log.d("TagTagTag", "Click1")
                val intent = Intent(this, Puzzle4x4Activity::class.java)
                startActivity(intent)
            }
            val buttonOpenActivity2: Button = binding.playButton3x3
            buttonOpenActivity2.setOnClickListener {
                Log.d("TagTagTag", "Click2")
                val intent = Intent(this, Puzzle3x3Activity::class.java)
                startActivity(intent)
            }

        } catch (e: Exception) {
            Log.d("TagTagTag", "Exception")
            e.printStackTrace()
        }
    }

    private fun onClickListener() {
        binding.playButton4x4.setOnClickListener() {
            Log.d("TagTagTag", "Click4x4")
            val intent = Intent(this, Puzzle4x4Activity::class.java)
            startActivity(intent)
        }
        binding.playButton3x3.setOnClickListener() {
            Log.d("TagTagTag", "Click3x3")
            val intent = Intent(this, Puzzle4x4Activity::class.java)
            startActivity(intent)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}