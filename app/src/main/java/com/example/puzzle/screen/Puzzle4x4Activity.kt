package com.example.puzzle.screen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.puzzle.R
import com.example.puzzle.databinding.ActivityPuzzle4x4Binding
import com.example.puzzle.presenter.PresenterPuzzle4x4
import com.example.puzzle.repository.RepositoryPuzzle4x4

class Puzzle4x4Activity : AppCompatActivity(R.layout.activity_puzzle_4x4) {
    private var _binding: ActivityPuzzle4x4Binding? = null
    private val binding: ActivityPuzzle4x4Binding get() = _binding!!
    private lateinit var repositoryPuzzle: RepositoryPuzzle4x4
    private lateinit var presenter: PresenterPuzzle4x4
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
        _binding = ActivityPuzzle4x4Binding.inflate(layoutInflater)
        setContentView(binding.root)
        repositoryPuzzle = RepositoryPuzzle4x4()
        presenter = PresenterPuzzle4x4(repository = repositoryPuzzle, view = this)

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
        binding.btn10.setOnClickListener { presenter.click(9) }
        binding.btn11.setOnClickListener { presenter.click(10) }
        binding.btn12.setOnClickListener { presenter.click(11) }
        binding.btn13.setOnClickListener { presenter.click(12) }
        binding.btn14.setOnClickListener { presenter.click(13) }
        binding.btn15.setOnClickListener { presenter.click(14) }
        binding.btn16.setOnClickListener { presenter.click(15) }
        binding.backButton.setOnClickListener() {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        binding.newGameButton.setOnClickListener() {
            startActivity(Intent(this, Puzzle4x4Activity::class.java))
            finish()
        }
    }

    fun startTimer() {
        time = 0
        timeIsRunning = true
        threadTimer.start()
    }

    fun stopTimer():Int {
        timeIsRunning = false
        binding.newGameButton.visibility = View.VISIBLE
        return time
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

            9 -> binding.btn10.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            10 -> binding.btn11.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            11 -> binding.btn12.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            12 -> binding.btn13.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            13 -> binding.btn14.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            14 -> binding.btn15.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            15 -> binding.btn16.apply {
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
            9 -> binding.btn10.apply { visibility = View.INVISIBLE }
            10 -> binding.btn11.apply { visibility = View.INVISIBLE }
            11 -> binding.btn12.apply { visibility = View.INVISIBLE }
            12 -> binding.btn13.apply { visibility = View.INVISIBLE }
            13 -> binding.btn14.apply { visibility = View.INVISIBLE }
            14 -> binding.btn15.apply { visibility = View.INVISIBLE }
            15 -> binding.btn16.apply { visibility = View.INVISIBLE }
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
