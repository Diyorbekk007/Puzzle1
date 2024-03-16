package com.example.puzzle.repository

class RepositoryPuzzle3x3 {
    fun getNumbers(): List<Int> {
        val ls = ArrayList<Int>()
        repeat(9) {
            ls.add(it + 1)
        }

        ls[7] = 9
        ls[8] = 7
        ls[9] = 8
        return ls
    }
}