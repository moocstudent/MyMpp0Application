package com.example.mympp0application

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform.reversed()}!"+
                "\nThere are only ${daysUntilNewYear()} left until New Year!"
    }
}