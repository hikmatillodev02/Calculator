package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// Added import for ArrayList
class MainActivity : AppCompatActivity() {
    var firstNum = 0.0 // Corrected variable name (firstname -> firstNum)
    var operation: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {  // Corrected method signature
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val num0 = findViewById<Button>(R.id.num0) // Corrected capitalization in "findViewById"
        val num1 = findViewById<Button>(R.id.num1)
        val num2 = findViewById<Button>(R.id.num2)
        val num3 = findViewById<Button>(R.id.num3)
        val num4 = findViewById<Button>(R.id.num4)
        val num5 = findViewById<Button>(R.id.num5)
        val num6 = findViewById<Button>(R.id.num6)
        val num7 = findViewById<Button>(R.id.num7)
        val num8 = findViewById<Button>(R.id.num8)
        val num9 = findViewById<Button>(R.id.num9)
        val on = findViewById<Button>(R.id.on)
        val off = findViewById<Button>(R.id.off)
        val ac = findViewById<Button>(R.id.ac)
        val del = findViewById<Button>(R.id.del)
        val div = findViewById<Button>(R.id.div)
        val times = findViewById<Button>(R.id.times)
        val plus = findViewById<Button>(R.id.plus)
        val minus = findViewById<Button>(R.id.minus)
        val nuqta = findViewById<Button>(R.id.nuqta)
        val equal = findViewById<Button>(R.id.equal)
        val screen = findViewById<TextView>(R.id.screen)
        ac.setOnClickListener { view: View? ->
            firstNum = 0.0
            screen.text = "0"
        }
        off.setOnClickListener { view: View? ->
            screen.visibility = View.GONE
        }
        on.setOnClickListener { view: View? ->
            screen.visibility = View.VISIBLE
            screen.text = "0"
        }
        val nums = ArrayList<Button>()
        nums.add(num0)
        nums.add(num1)
        nums.add(num2)
        nums.add(num3)
        nums.add(num4)
        nums.add(num5)
        nums.add(num6)
        nums.add(num7)
        nums.add(num8)
        nums.add(num9)
        for (b in nums) {
            b.setOnClickListener { view: View? ->
                if (screen.text.toString() != "0") {
                    screen.text = screen.text.toString() + b.text.toString()
                } else {
                    screen.text = b.text.toString()
                }
            }
        }
        val opers = ArrayList<Button>()
        opers.add(div)
        opers.add(times)
        opers.add(plus)
        opers.add(minus)
        for (b in opers) {
            b.setOnClickListener { view: View? ->
                firstNum = screen.text.toString().toDouble()
                operation = b.text.toString()
                screen.text = "0" // Corrected method call (screen.setText. -> screen.setText())
            }
        }
        del.setOnClickListener { view: View? ->
            val num = screen.text.toString()
            if (num.length > 1) {
                screen.text = num.substring(0, num.length - 1)
            } else if (num.length == 1 && num != "0") {
                screen.text = "0"
            }
        }
        nuqta.setOnClickListener { view: View? ->
            if (screen.text.toString().contains(".")) {
                screen.text = screen.text.toString() + "0"
            }
        }
        equal.setOnClickListener { view: View? ->
            val secondNum = screen.text.toString()
                .toDouble() // Corrected variable name (seconNum -> secondNum)
            val result: Double
            result = when (operation) {
                "/" -> firstNum / secondNum
                "X" -> firstNum * secondNum
                "+" -> firstNum + secondNum
                "-" -> firstNum - secondNum
                else -> firstNum + secondNum
            }
            screen.text = result.toString()
            firstNum = result // Corrected variable assignment
        }
    }
}