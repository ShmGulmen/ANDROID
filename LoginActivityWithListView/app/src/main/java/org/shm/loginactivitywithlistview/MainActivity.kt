package org.shm.loginactivitywithlistview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.shm.loginactivitywithlistview.entity.UserInfo

class MainActivity : AppCompatActivity() {
    private lateinit var mUsersAdapter : ArrayAdapter<UserInfo>

    private fun getUserInfo(user: UserInfo) : Boolean
    {
        var username = MainActivityEditTextUserName.text.toString().trim()
        var password = MainAcivityEditTextPassword.text.toString()
        var passwordControl = MainActivityEditTextPasswordAgain.text.toString()

        if (password != passwordControl)
            return false

        user.username = username
        user.password = password

        return true
    }

    private fun initViews()
    {
        mUsersAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, ArrayList<UserInfo>())
        MainActivityListViewUsers.adapter = mUsersAdapter
        MainActivityListViewUsers.setOnItemClickListener { _, _, position, _ ->
            var user = mUsersAdapter.getItem(position)

            var intent = Intent(this, UserDetailsActivity::class.java)

            intent.putExtra("USER", user)

            startActivity(intent)
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

    fun onRegisterButtonClicked(view: View)
    {
        try {
            var user = UserInfo()

            if (!getUserInfo(user)) {
                Toast.makeText(this, "Password must be confirmed", Toast.LENGTH_LONG).show()
                return
            }

            mUsersAdapter.add(user)
            mUsersAdapter.notifyDataSetChanged()
        }
        catch (ex : Throwable){
            Toast.makeText(this, "An unexpected error occurred.", Toast.LENGTH_LONG).show()
        }
    }
}
