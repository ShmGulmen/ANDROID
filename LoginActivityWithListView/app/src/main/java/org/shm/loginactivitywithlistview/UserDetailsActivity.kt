package org.shm.loginactivitywithlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_user_details.*
import org.shm.loginactivitywithlistview.entity.UserInfo

class UserDetailsActivity : AppCompatActivity() {

    private fun initViews()
    {
        var user = intent.getSerializableExtra("USER") as UserInfo

        UserDetailsActivityTextViewUserName.text = user.username
        UserDetailsActivityTextViewPassword.text = user.password
    }
    private fun init()
    {
        initViews()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)
        init()
    }

    fun OKButtonClicked(view: View)
    {
        finish()
    }
    fun onPasswordTextViewClicked(view: View)
    {
        Toast.makeText(this, UserDetailsActivityTextViewPassword.text, Toast.LENGTH_SHORT).show()
    }
}
