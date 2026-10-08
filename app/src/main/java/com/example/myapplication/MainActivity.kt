package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAdd.setOnClickListener {
            calculate("+")
            Toast.makeText(this@MainActivity, "Add operation worked", Toast.LENGTH_SHORT).show()
        }
    }
    fun calculate(operation : String) {
        val number1Text = binding.Number1.text.toString().trim()
        val number2Text = binding.Number2.text.toString().trim()

        //validation
        if(number1Text.isEmpty()){
            binding.Number1.error ="Please enter number 1"
            binding.Number1.requestFocus()
            return
        }
        if(number2Text.isEmpty()){
            binding.Number2.error ="Please enter number 2"
            binding.Number2.requestFocus()
            return
        }
        val number1 = number1Text.toDouble()
        val number2 = number2Text.toDouble()

    val result = when(operation)  {
         "+" -> number1 + number2
         else -> 0.0
     }
        binding.tvResult.text = "Result : $result"
    }
}