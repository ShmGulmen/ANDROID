package org.shm.a013_startanotheractivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onStartAnotherActivity(view: View)
    {
        val intent = Intent(this, SecondActivity::class.java)

        startActivity(intent)
    }

    fun onExitButtonClicked(view: View)
    {
        finish()
    }
}
