package com.example.puzzle.repository

class RepositoryPuzzle4x4 {
    fun getNumbers(): List<Int> {
        val ls = ArrayList<Int>()
        repeat(16) {
            ls.add(it + 1)
        }

        ls[14]=14
        ls[13]=16
        ls[15]=15
        return ls
    }
}