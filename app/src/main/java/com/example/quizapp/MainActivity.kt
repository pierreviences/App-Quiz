package com.example.quizapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    // step 2 -> create question, option, and answer array
    private val questions = arrayOf("what is the built-in database in Andorid Studio?",
        "What is the full from of APK in Android Development?",
        "In Which year, frist andorid was relesead by Google?")

    private val options = arrayOf(arrayOf("MySQL", "SQLite", "FireBase"),
        arrayOf("Aplication Programing Interace", "Android programming interface", "Andori Package Information")
        ,arrayOf("2010", "2006", "2008"))

    private val correctAnswer = arrayOf(1,0, 2)

    // step 3 -> create question index and score value
    private var currecntQuestionIndex = 0
    private var score = 0











    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // step 1 -> setup binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }

   

}