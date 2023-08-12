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

    // step 4 -> correctButtonColors() method
    private fun correctButtonColors(buttonIndex: Int){
        when(buttonIndex){
            0 -> binding.option1Button.setBackgroundColor(Color.GREEN)
            1 -> binding.option2Button.setBackgroundColor(Color.GREEN)
            2 -> binding.option3Button.setBackgroundColor(Color.GREEN)
        }
    }

    // step 5 -> wrongButtonColors() method
    private fun wrongButtonColors(buttonIndex: Int) {
        when(buttonIndex){
            0 -> binding.option1Button.setBackgroundColor(Color.RED)
            1 -> binding.option2Button.setBackgroundColor(Color.RED)
            2 -> binding.option3Button.setBackgroundColor(Color.RED)
        }

    }

    // step 6 -> resetButtonColors() method
    private fun resetButtonColors(){
        binding.option1Button.setBackgroundColor(Color.rgb(50,90,96))
        binding.option2Button.setBackgroundColor(Color.rgb(50,90,96))
        binding.option3Button.setBackgroundColor(Color.rgb(50,90,96))
    }

    // step 7 -> showResult()
    private fun showResults(){
        Toast.makeText(this, "Your Score : $score out of ${questions.size}", Toast.LENGTH_SHORT).show()
        binding.restartButton.isEnabled = true
    }

    // step 8 -> displayQuestion()
    private fun displayQuestion(){
        binding.questionText.text = questions[currecntQuestionIndex]
        binding.option1Button.text = options[currecntQuestionIndex][0]
        binding.option2Button.text = options[currecntQuestionIndex][1]
        binding.option3Button.text = options[currecntQuestionIndex][2]
        resetButtonColors()

    }

    // step 9 -> checkAnswer()
    private fun checkAnswer(selectedAnswerIndex: Int){
        val correctAnswerIndex = correctAnswer[currecntQuestionIndex]
        if(selectedAnswerIndex == correctAnswerIndex){
            score++
            correctButtonColors(selectedAnswerIndex)
        }else {
            wrongButtonColors(selectedAnswerIndex)
            correctButtonColors(selectedAnswerIndex)
        }
        if(currecntQuestionIndex < questions.size - 1){
            currecntQuestionIndex++
            binding.questionText.postDelayed({displayQuestion()}, 1000)
        }else{
            showResults()
        }
    }
    // step 10 -> restartQuiz()
    private fun restartQuiz(){
        currecntQuestionIndex = 0
        score = 0
        displayQuestion()
        binding.restartButton.isEnabled = false
    }

}