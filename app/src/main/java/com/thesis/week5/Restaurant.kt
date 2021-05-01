package com.thesis.week5

class Restaurant (val name:String, val address : String, val avatar : Int, var fav : Boolean) {
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun toString(): String {
        return super.toString()
    }
}