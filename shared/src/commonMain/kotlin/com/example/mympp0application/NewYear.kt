package com.example.mympp0application

import kotlinx.datetime.*

fun daysUntilNewYear():Int{
    val today=Clock.System.todayAt(TimeZone.currentSystemDefault())
    val closetNewYear = LocalDate(today.year+1,1,1)
    return today.daysUntil(closetNewYear)
}