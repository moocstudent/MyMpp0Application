package com.example.mympp0application

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform.reversed()}!"
    }
}