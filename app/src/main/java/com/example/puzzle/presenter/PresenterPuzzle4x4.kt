package com.example.puzzle.presenter

import android.util.Log
import com.example.puzzle.screen.Puzzle4x4Activity
import com.example.puzzle.repository.RepositoryPuzzle4x4

class PresenterPuzzle4x4(
    private val repository: RepositoryPuzzle4x4,
    private val view: Puzzle4x4Activity
) {
    private val numbers = ArrayList(repository.getNumbers())
    private var hideIndex = 0
    private var countStep = 0

    init {
        numbers.forEachIndexed { index, i ->
            if (i == 16)
                hideIndex = index
        }
        view.loadButtons(numbers)
    }

    fun click(index: Int) {
        if (checkCanReplace(index)) {
            if (countStep == 0)
                view.startTimer()
            countStep++
            view.hideVisible(index)
            view.setText(numbers[index], hideIndex)
            replace(index)
            if (checkIsSuccess()) {
                val a=view.stopTimer()
                Log.e("AAAbbbccc",a.toString())
                view.showAlertDialog()
            } else {
                view.loadCount(countStep)
            }
        }
    }

    private fun checkCanReplace(index: Int): Boolean {
        return hideIndex - 4 == index || hideIndex + 4 == index || hideIndex - 1 == index || hideIndex + 1 == index
    }

    private fun replace(fromIndex: Int) {
        val t = numbers[fromIndex]
        numbers[fromIndex] = numbers[hideIndex]
        numbers[hideIndex] = t
        hideIndex = fromIndex
    }

    private fun checkIsSuccess(): Boolean {
        var cond = true
        numbers.forEachIndexed { index, i ->
            if (index + 1 != i) {
                cond = false
            }
        }
        return cond
    }

}