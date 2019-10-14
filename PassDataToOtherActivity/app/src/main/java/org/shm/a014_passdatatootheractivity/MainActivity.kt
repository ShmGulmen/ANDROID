package org.shm.a014_passdatatootheractivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onOKButtonClicked(view: View)
    {
        try {
            val intent = Intent(this, UserDetailsActivity::class.java)

            intent.putExtra(
                FULLNAME, MainActivityEditTextName.text.toString() +
                    "" + MainActivityEditTextSurname.text.toString())
            intent.putExtra(USERNAME, MainActivityEditTextUsername.text.toString())
            intent.putExtra(EMAİL, MainActivityEditTextEmail.text.toString())
            intent.putExtra(GENDER, MainActivityCheckBoxGender.isChecked)

            startActivity(intent)
        }
        catch (ex: Throwable){
            Toast.makeText(this, ex.message, Toast.LENGTH_LONG).show()
        }

    }
    fun onExitButtonClicked(view: View)
    {
        finish()
    }
}
