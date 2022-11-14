package com.example.utiltiesclassapp

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.animation.BounceInterpolator
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.utiltiesclassapp.utils.scale
import com.example.utiltiesclassapp.utils.translateYBy

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txt = findViewById<TextView>(R.id.text1)
        val btn = findViewById<Button>(R.id.btn_click)

        btn.setOnClickListener {
            //This is a Property Animator
           ObjectAnimator.ofFloat(txt,"translationY",200f).apply {
               duration = 1000
               interpolator = BounceInterpolator()
               start()
           }
        }


    }
}