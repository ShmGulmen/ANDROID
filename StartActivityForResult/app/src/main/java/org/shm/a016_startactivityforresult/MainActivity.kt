package org.shm.a016_startactivityforresult

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.ComponentCallbacks2
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private fun getUserInfo() : UserInfo
    {
        val fulname = "${MainActivityEditTextName.text.toString()} ${MainActivityEditTextSurname.text.toString()}"
        val username = MainActivityEditTextUsername.text.toString()
        val email = MainActivityEditTextEmail.text.toString()
        val isFemale = MainActivityCheckBoxGender.isChecked

        return UserInfo(fulname, username, email, isFemale)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE){
            if (resultCode == Activity.RESULT_OK) {
                val userInfo = data?.getSerializableExtra(USERINFO) as UserInfo
                var fullNameDate = userInfo.fullname.split(' ')

                MainActivityEditTextName.setText(fullNameDate[0])
                MainActivityEditTextSurname.setText(fullNameDate[1])
            }
            else
                Toast.makeText(this, "Did not update any data", Toast.LENGTH_LONG).show()
        }
    }
    fun onOKButtonClicked(view: View)
    {
        try {
            val intent = Intent(this, UserDetailsActivity::class.java)

            intent.putExtra(USERINFO, getUserInfo())

            startActivityForResult(intent, REQUEST_CODE)
        }
        catch (ex : Throwable){
            Toast.makeText(this, ex.message, Toast.LENGTH_LONG).show()
        }
    }
    fun onExitButtonClicked(view: View)
    {
        finish()
    }
}
