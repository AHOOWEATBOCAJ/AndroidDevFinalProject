package com.example.myapplication


import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.R
import com.example.myapplication.MainActivity
import java.util.Timer


class MainActivity : AppCompatActivity() {


    //val TAG = "MainActivity"


    //Buttons, numbers, and score for the answer
    //private lateinit var button1: Button
    //private lateinit var button2: Button
    //private lateinit var button3: Button
    //private lateinit var button4: Button
    //private lateinit var score: TextView
    private var scoreNum: Int = 0
    private var answer: Int = 0


    //Title screen
    //private lateinit var titleText: TextView
    //private lateinit var butEndless: Button
    //private lateinit var butTimed: Button


    //Numbers for the equation
    //private lateinit var equation
    private var equNum1: Int = (Math.random() * 1000).toInt()
    private var equNum2: Int = (Math.random() * 1000).toInt()
    private var symbol: Int = (Math.random() * 3).toInt()

    /*private var isRunning = false
    private var seconds = 0
    private val handler = Handler(Looper.getMainLooper())
    private val runnable = object : Runnable {
        override fun run(){
            seconds++

            handler.postDelayed(this, 1000)
        }
    }*/

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // assign a value to binding the variable
        binding = ActivityMainBinding.inflate(layoutInflater)
        // set the content view to the binding's root
        setContentView(R.layout.activity_title)
        var endlessButton = findViewById<Button>(R.id.button_title_endless)
        endlessButton.setOnClickListener {
            setContentView(binding.root)
            setEquation()
            setAnswerListeners()
        }
        /*var timedButton = findViewById<Button>(R.id.button_title_timed)
        timedButton.setOnClickListener {
            setContentView(binding.root)
            binding.textViewMainTimer.text = "Time: "
            startTimer()
            setEquation()
            setAnswerListeners()
        }*/
    }

    fun setAnswerListeners() {
        var randomAnswer: Int = (Math.random() * 4).toInt()

        if (randomAnswer == 0) {
            binding.buttonMainAns1.text = answer.toString()
            answer += 10
            binding.buttonMainAns2.text = answer.toString()
            answer -= 10
            answer++
            binding.buttonMainAns3.text = answer.toString()
            answer--
            answer -= 10
            binding.buttonMainAns4.text = answer.toString()

            binding.buttonMainAns1.setOnClickListener {
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
                setEquation()
                setAnswerListeners()
                upScore()
            }
            binding.buttonMainAns2.setOnClickListener {
                Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
            }
            binding.buttonMainAns3.setOnClickListener {
                Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
            }
            binding.buttonMainAns4.setOnClickListener {
                Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
            }
        } else if (randomAnswer == 1) {
            binding.buttonMainAns2.text = answer.toString()
            answer += 10
            binding.buttonMainAns1.text = answer.toString()
            answer -= 10
            answer++
            binding.buttonMainAns3.text = answer.toString()
            answer--
            answer -= 10
            binding.buttonMainAns4.text = answer.toString()
            binding.buttonMainAns2.setOnClickListener {
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
                setEquation()
                setAnswerListeners()
                upScore()
            }
            binding.buttonMainAns1.setOnClickListener {
                Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
                throw RuntimeException("Intentional Crash")
            }
            binding.buttonMainAns3.setOnClickListener {
                Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
                throw RuntimeException("Intentional Crash")
            }
            binding.buttonMainAns4.setOnClickListener {
                Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
                throw RuntimeException("Intentional Crash")
            }
        } else if (randomAnswer == 2) {
            binding.buttonMainAns3.text = answer.toString()
            answer += 10
            binding.buttonMainAns2.text = answer.toString()
            answer -= 10
            answer++
            binding.buttonMainAns1.text = answer.toString()
            answer--
            answer -= 10
            binding.buttonMainAns4.text = answer.toString()
            binding.buttonMainAns3.setOnClickListener {
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
                setEquation()
                setAnswerListeners()
                upScore()
            }
            binding.buttonMainAns1.setOnClickListener {
                Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
                throw RuntimeException("Intentional Crash")
            }
            binding.buttonMainAns2.setOnClickListener {
                Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
                throw RuntimeException("Intentional Crash")
            }
            binding.buttonMainAns4.setOnClickListener {
                Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
                throw RuntimeException("Intentional Crash")
            }
        } else {
            binding.buttonMainAns4.text = answer.toString()
            answer += 10
            binding.buttonMainAns2.text = answer.toString()
            answer -= 10
            answer++
            binding.buttonMainAns3.text = answer.toString()
            answer--
            answer -= 10
            binding.buttonMainAns1.text = answer.toString()
            binding.buttonMainAns4.setOnClickListener {
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
                setEquation()
                setAnswerListeners()
                upScore()
            }
            binding.buttonMainAns1.setOnClickListener {
                Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
                throw RuntimeException("Intentional Crash")
            }
            binding.buttonMainAns2.setOnClickListener {
                Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
                throw RuntimeException("Intentional Crash")
            }
            binding.buttonMainAns3.setOnClickListener {
                Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
                throw RuntimeException("Intentional Crash")
            }
        }
    }


    fun setEquation() {
        if (symbol == 0) {
            binding.textViewMainEqu.text = "$equNum1 + $equNum2"
            answer = equNum1 + equNum2
        } else if (symbol == 1) {
            binding.textViewMainEqu.text = "$equNum1 - $equNum2"
            answer = equNum1 - equNum2
        } else {
            binding.textViewMainEqu.text = "$equNum1 * $equNum2"
            answer = equNum1 * equNum2
        }

        equNum1 = (Math.random() * 1000).toInt()
        equNum2 = (Math.random() * 1000).toInt()
        symbol = (Math.random() * 3).toInt()
    }


    fun upScore() {
        scoreNum++
        binding.textViewMainScore.text = "" + scoreNum
    }


    /*private fun startTimer(){
        if(!isRunning)
            handler.postDelayed(runnable, 1000)
        isRunning=true
    }*/
}