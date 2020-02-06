package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        draw_view.addLine(0f,400f,"A")
        draw_view.addLine(90f,300f,"B")
        draw_view.enclose("C", "A")
        draw_view.draw()

    }
}
