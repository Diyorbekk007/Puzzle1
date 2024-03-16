package com.example.puzzle.screen

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.puzzle.R
import com.example.puzzle.databinding.ActivityPuzzle3x3Binding
import com.example.puzzle.presenter.PresenterPuzzle3x3
import com.example.puzzle.repository.RepositoryPuzzle3x3

class Puzzle3x3Activity : AppCompatActivity(R.layout.activity_puzzle_3x3) {
    private var _binding: ActivityPuzzle3x3Binding? = null
    private val binding: ActivityPuzzle3x3Binding get() = _binding!!
    private lateinit var repositoryPuzzle: RepositoryPuzzle3x3
    private lateinit var presenter: PresenterPuzzle3x3
    private val looper = Looper.getMainLooper()
    private val handler = Handler(looper)
    private var time = 0
    private var timeIsRunning = true
    private val threadTimer = Thread {
        while (timeIsRunning) {
            Thread.sleep(1000)
            time++
            handler.post {
                val min = time / 60
                val sec = time % 60
                val minText = if (min > 9) min.toString() else "0$min"
                val secText = if (sec > 9) sec.toString() else "0$sec"
                binding.time.text = "$minText : $secText"
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityPuzzle3x3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        repositoryPuzzle = RepositoryPuzzle3x3()
        presenter = PresenterPuzzle3x3(repository = repositoryPuzzle, view = this)

        loadUiClickable()
    }

    private fun loadUiClickable() {
        binding.btn1.setOnClickListener { presenter.click(0) }
        binding.btn2.setOnClickListener { presenter.click(1) }
        binding.btn3.setOnClickListener { presenter.click(2) }
        binding.btn4.setOnClickListener { presenter.click(3) }
        binding.btn5.setOnClickListener { presenter.click(4) }
        binding.btn6.setOnClickListener { presenter.click(5) }
        binding.btn7.setOnClickListener { presenter.click(6) }
        binding.btn8.setOnClickListener { presenter.click(7) }
        binding.btn9.setOnClickListener { presenter.click(8) }

    }

    fun startTimer() {
        time = 0
        timeIsRunning = true
        threadTimer.start()
    }

    fun stopTimer() {
        timeIsRunning = false
    }

    fun loadCount(count: Int) {
        binding.count.text = count.toString()
    }

    fun loadButtons(list: List<Int>) {
        list.forEachIndexed { index, i ->
            if (i == 16)
                hideVisible(index)
            else
                setText(i, index)
        }
    }

    fun setText(textBtn: Int, btnIndex: Int) {
        when (btnIndex) {
            0 -> binding.btn1.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            1 -> binding.btn2.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            2 -> binding.btn3.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            3 -> binding.btn4.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            4 -> binding.btn5.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            5 -> binding.btn6.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            6 -> binding.btn7.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            7 -> binding.btn8.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            8 -> binding.btn9.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }


        }
    }

    fun hideVisible(btnIndex: Int) {
        when (btnIndex) {
            0 -> binding.btn1.apply { visibility = View.INVISIBLE }
            1 -> binding.btn2.apply { visibility = View.INVISIBLE }
            2 -> binding.btn3.apply { visibility = View.INVISIBLE }
            3 -> binding.btn4.apply { visibility = View.INVISIBLE }
            4 -> binding.btn5.apply { visibility = View.INVISIBLE }
            5 -> binding.btn6.apply { visibility = View.INVISIBLE }
            6 -> binding.btn7.apply { visibility = View.INVISIBLE }
            7 -> binding.btn8.apply { visibility = View.INVISIBLE }
            8 -> binding.btn9.apply { visibility = View.INVISIBLE }

        }
    }

    fun showAlertDialog() {
        val alertDialogBuilder = AlertDialog.Builder(this)
            .setTitle("Good Job!")
            .setMessage("Siz Puzzleni yig'ib bo'ldingiz")
            .setPositiveButton("Yes") { _, _ ->
            }

            .show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
