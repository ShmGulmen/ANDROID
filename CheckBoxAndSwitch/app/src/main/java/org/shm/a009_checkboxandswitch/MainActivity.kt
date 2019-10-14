package org.shm.a009_checkboxandswitch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    private fun initViews()
    {
        MainActivityCheckBoxAccept.setOnCheckedChangeListener {
                _, b ->
            Toast.makeText(this, if (b) "Accept" else "Not Accept it", Toast.LENGTH_LONG).show()
        }
        MainActivitySwitchSupported.setOnCheckedChangeListener(this)
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

    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean)
    {
        Toast.makeText(this, if (p1) "Support it" else "Not Support it", Toast.LENGTH_LONG).show()
    }

    fun onButtonClicked(view: View)
    {
        var msg = if (MainActivityCheckBoxAccept.isChecked) "Accept it" else "Not Accept it"

        MainActivityTextViewAcceptResult.text = msg

        msg = if (MainActivitySwitchSupported.isChecked) "Support it" else "Not Support it"

        MainActivityTextViewSwitchResult.text = msg
    }
}
