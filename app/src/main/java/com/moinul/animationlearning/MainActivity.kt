package com.moinul.animationlearning

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var buttonOne: Button
    private lateinit var buttonTwo: Button
    private lateinit var ballButton: Button
    private lateinit var starImage: ImageView
    private lateinit var ballImage: ImageView
    private lateinit var sampleTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonOne = findViewById(R.id.button1)
        buttonTwo = findViewById(R.id.button2)
        ballButton = findViewById(R.id.button3)
        starImage = findViewById(R.id.starImageView)
        ballImage = findViewById(R.id.ballImage)
        sampleTextView = findViewById(R.id.textView)

        buttonOne.setOnClickListener{
            val animator = ObjectAnimator.ofFloat(starImage, View.ROTATION, 0f, 360f)
            animator.repeatCount = 1
            animator.duration = 1500
            animator.repeatMode = ObjectAnimator.REVERSE
            animator.start()
        }

        buttonTwo.setOnClickListener{
            val animation = AnimationUtils.loadAnimation(this, R.anim.rotate)
            sampleTextView.startAnimation(animation)
        }

        ballButton.setOnClickListener {

            //rollBall()
            rollBallXml()
        }
    }

    fun rollBall(){
        val translation = ObjectAnimator.ofFloat(ballImage, View.TRANSLATION_X,  0f, 900f)
        translation.repeatCount = 1
        translation.repeatMode = ObjectAnimator.REVERSE
        translation.duration = 1500

        val rotation = ObjectAnimator.ofFloat(ballImage, View.ROTATION, 0f, 360f)
        rotation.repeatCount = 1
        rotation.repeatMode = ObjectAnimator.REVERSE
        rotation.duration = 1500

        translation.start()
        rotation.start()
    }
    fun rollBallXml(){
        val roll = AnimationUtils.loadAnimation(this, R.anim.roll)
        ballImage.startAnimation(roll)
    }
}