package com.example.puzzle.presenter

import com.example.puzzle.repository.RepositoryPuzzle3x3
import com.example.puzzle.screen.Puzzle3x3Activity

class PresenterPuzzle3x3(
    private val repository: RepositoryPuzzle3x3,
    private var view: Puzzle3x3Activity
) {
    private val numbers = ArrayList(repository.getNumbers())
    private var hideIndex = 0
    private var countStep = 0

    init {
        numbers.forEachIndexed { index, i ->
            if (i == 9)
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
                view.stopTimer()
                view.showAlertDialog()
            } else {
                view.loadCount(countStep)
            }
        }
    }

    private fun checkCanReplace(index: Int): Boolean {
        return hideIndex - 3 == index || hideIndex + 3 == index || hideIndex - 1 == index || hideIndex + 1 == index
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