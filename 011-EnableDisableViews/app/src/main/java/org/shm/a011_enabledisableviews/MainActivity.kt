package org.shm.a011_enabledisableviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Switch
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private fun clearViews()
    {
        var count = MainActivityLinearLayoutViews.childCount

        for (i in 0 until count) {
            var elements = MainActivityLinearLayoutViews.getChildAt(i)

            if (elements is Switch)
                elements.isChecked

            if (elements is EditText)
                elements.setText("")
        }
    }

    private fun enableViews(enable : Boolean = true)
    {
        var count = MainActivityLinearLayoutViews.childCount

        for (i in 0 until count)
            MainActivityLinearLayoutViews.getChildAt(i).isEnabled = enable
    }

    private fun initViews()
    {
        enableViews(MainActivityToggleButtonOpenClose.isChecked)
        MainActivityToggleButtonOpenClose.setOnCheckedChangeListener {
                _, b ->
            enableViews(b)
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

    fun onButtonClearclicked(view: View)
    {
        if (MainActivityToggleButtonOpenClose.isChecked)
            clearViews()
    }
}
