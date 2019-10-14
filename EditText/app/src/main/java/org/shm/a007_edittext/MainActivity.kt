package org.shm.a007_edittext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private fun validate(firstName: String, surname: String) : Boolean
    {
        var errMsg = ""

        if (firstName.isEmpty() || surname.isEmpty())
            errMsg += "cannot be empty"

        var status = errMsg == ""

        if(!status)
            Toast.makeText(this, errMsg, Toast.LENGTH_LONG).show()

        return status
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onSaveButtonClicked(view: View)
    {
        var firstName = MainActivityEditTextFirstName.text.toString().trim()
        var surname = MainActivityEditTextSurname.text.toString().trim()

        if (!validate(firstName, surname))
            return

        var secondName = MainActivityEditTextSecondName.text.toString()

        var fullName = "${firstName.toLowerCase().capitalize()} ${if(secondName.isBlank()) "" else "" + secondName.toLowerCase().capitalize() + ""} ${surname.toUpperCase()}"

        MainActivityTextViewFullName.text = fullName
    }

    fun onFullNameTextViewClicked(view: View)
    {
        var text = MainActivityTextViewFullName.text

        if (!text.isEmpty())
            Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    fun onExitButtonClicked(view: View)
    {
        finish()
    }


}
