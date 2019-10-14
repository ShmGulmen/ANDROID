package org.shm.a014_passdatatootheractivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_user_details.*

class UserDetailsActivity : AppCompatActivity() {

    private fun initView()
    {
        UserDetailsActivityTextViewUserName.text = intent.getStringExtra(USERNAME)
        UserDetailsActivityEditTextFullName.setText(intent.getStringExtra(FULLNAME))
        UserDetailsActivityTextViewEmail.text = intent.getStringExtra(EMAİL)
        UserDetailsActivityTextViewGender.text =
            if (intent.getBooleanExtra(GENDER, true)) "Female" else "Male"
    }

    private fun init()
    {
        initView()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)
        init()
    }

    fun onExitButtonClicked(view: View)
    {
        finish()
    }
}
