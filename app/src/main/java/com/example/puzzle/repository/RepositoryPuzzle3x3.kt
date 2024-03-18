package com.example.puzzle.repository

class RepositoryPuzzle3x3 {
    var lss: ArrayList<Int>? = null
    public fun getNumbers(): List<Int> {
        val ls = ArrayList<Int>()
        repeat(9) {
            ls.add(it + 1)
        }
        ls.shuffle()
        lss = ls
//        ls[6] = 7
//        ls[7] = 9
//        ls[8] = 8
        return ls
    }
    fun ddd(){
        lss
    }
}