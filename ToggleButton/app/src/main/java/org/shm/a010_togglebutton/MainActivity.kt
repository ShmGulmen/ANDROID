package org.shm.a010_togglebutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private fun initViews()
    {
        MainActivityToggleButtonOpenClose.setOnCheckedChangeListener {
                _, b ->
            Toast.makeText(this, if (b) "Open" else "Close", Toast.LENGTH_LONG).show()
        }

    }
    private fun init()
    {
        initViews()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
}
