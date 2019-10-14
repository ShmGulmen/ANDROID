package org.shm.a016_startactivityforresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.TokenWatcher
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_user_details.*

class UserDetailsActivity : AppCompatActivity() {

    private lateinit var mUserInfo: UserInfo

    private fun initViews()
    {
        mUserInfo = intent.getSerializableExtra(USERINFO) as UserInfo

        UserDetailsActivityEditTextFullname.setText(mUserInfo.fullname)
        UserDetailsActivityTextViewUsername.text = mUserInfo.username
        UserDetailsActivityTextViewEmail.text = mUserInfo.email
        UserDetailsActivityTextViewFemale.text = if (mUserInfo.isFemale) "Female" else "Male"

        Toast.makeText(this, mUserInfo.toString(), Toast.LENGTH_LONG).show()

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

    fun onSaveButtonClicked(view: View)
    {
        mUserInfo.fullname = UserDetailsActivityEditTextFullname.text.toString()

        val intent = Intent()

        intent.putExtra(USERINFO, mUserInfo)

        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    fun onExitButtonClicked(view: View)
    {
        finish()
    }


}
