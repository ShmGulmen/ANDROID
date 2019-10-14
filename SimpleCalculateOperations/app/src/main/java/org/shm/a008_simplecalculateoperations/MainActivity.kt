package org.shm.a008_simplecalculateoperations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private fun validate() : Pair<Double, Double>?
    {
        var errMsg = ""
        var firstNumber = 0.0
        var secondNumber = 0.0

        try {
            firstNumber = MainActivityEditTextFirstNumber.text.toString().toDouble()
        }
        catch (ex: Throwable){
            errMsg += "First Number is validate"
        }

        try {
            secondNumber = MainActivityEditTextSecondNumber.text.toString().toDouble()
        }
        catch (ex: Throwable){
            errMsg += "\n Second Number is validate"
        }

        var status = errMsg == ""

        if (!status) {
            Toast.makeText(this, errMsg, Toast.LENGTH_LONG).show()
            return null
        }

        return Pair(firstNumber, secondNumber)
    }

    private fun calculate(numbers : Pair<Double, Double>)
    {
        var result = ""
        val (first, second) = numbers

        result += "$first + $second = ${first + second}\n"
        result += "$first - $second = ${first - second}\n"
        result += "$first * $second = ${first * second}\n"
        result += "$first / $second = ${first / second}\n"
        result += "$first % $second = ${first % second}"

        MainActivityTextViewResult.text = result
    }

    private fun clear()
    {
        MainActivityEditTextFirstNumber.setText("")
        MainActivityEditTextSecondNumber.setText("")
        MainActivityTextViewResult.text = ""

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onCalculateButtonClicked(view: View)
    {
        var numbers = validate()

        if (numbers != null)
            calculate(numbers)
    }
    fun onCleanButtonClicked(view: View)
    {
        clear()
    }
    fun onExitButtonClicked(view: View)
    {
        finish()
    }
}
