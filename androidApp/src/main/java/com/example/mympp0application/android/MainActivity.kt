package com.example.mympp0application.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mympp0application.Greeting
import android.widget.TextView
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

//
//fun greet(): String {
//    return Greeting().greeting()
//}

class MainActivity : AppCompatActivity() {
    private val scope = MainScope()

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = "Loading..."

        scope.launch {
            kotlin.runCatching{
                /**
                 * The greeting() function is now called
                 * inside the coroutine launched in the main
                 * CoroutineScope
                 */
                Greeting().greeting()
            }.onSuccess {
                tv.text=it
            }.onFailure {
                tv.text=it.localizedMessage
            }
        }
    }
}
