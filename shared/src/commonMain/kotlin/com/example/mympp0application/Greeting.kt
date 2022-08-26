package com.example.mympp0application

import com.example.mympp0application.entity.RocketLaunch
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class Greeting {

    private val httpClient= HttpClient{
        install(ContentNegotiation){
            json(Json{
                prettyPrint=true
                isLenient=true
                ignoreUnknownKeys=true
            })
        }
    }

    @Throws(Exception::class)
    suspend fun greeting(): String {
        val rockets:List<RocketLaunch> = httpClient.get("https://api.spacexdata.com/v4/launches").body()
        val lastSuccessLaunch = rockets.last {it.launchSuccess==true}
        return "Hello, ${Platform().platform.reversed()}!"+
                "\nThere are only ${daysUntilNewYear()} left until New Year!"+
                "\nThe last successful launch was ${lastSuccessLaunch.launchDateUTC} ð"
    }

}