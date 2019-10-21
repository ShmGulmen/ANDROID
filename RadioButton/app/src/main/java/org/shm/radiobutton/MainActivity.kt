package org.shm.radiobutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private fun checkChangeRadioGrup(rg : RadioGroup, id: Int)
    {
        Toast.makeText(this, findViewById<RadioButton>(id).tag as String, Toast.LENGTH_SHORT).show()
    }
    private fun initViews()
    {
        MainActivityRadioGroupMaritalStatus.setOnCheckedChangeListener(this::checkChangeRadioGrup)
        MainActivityRadioGrupEducation.setOnCheckedChangeListener {
                rg, id ->

            if (id == R.id.MainActivityradioButtonOther)
                MainActivityEditTextEnterYourEducation.visibility = View.VISIBLE
            else
                MainActivityEditTextEnterYourEducation.setText("")
                MainActivityradioButtonOther.visibility = View.GONE

            checkChangeRadioGrup(rg, id)
        }
    }

    private fun init()
    {
        initViews()
    }

    // With Parameter
    private fun getSelectedRadio(radiogroup : RadioGroup) = findViewById<RadioButton>(radiogroup.checkedRadioButtonId)

    private fun getSelectedRadioButtonWithLoop(radioGroup : RadioGroup): RadioButton?
    {
        val childcount = radioGroup.childCount

        for (i in 0 until childcount){
            val view = radioGroup.getChildAt(i)

            if (view !is RadioButton)
                continue

            if (view .isChecked)//SMART CAST
                return view
        }

        return null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun onOKButtonClicked(view: View)
    {
        var msg = "Educaton Statement :  ${getSelectedRadio(MainActivityRadioGrupEducation).text}"

        msg +=  "Marital Status : ${getSelectedRadioButtonWithLoop(MainActivityRadioGroupMaritalStatus)?.text}"

        MainActivityTextViewResult.text = msg
    }
}
