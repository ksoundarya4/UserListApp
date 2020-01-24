package com.bridgelabs.userlist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.EditText
import android.widget.TextView
import com.bridgelabs.userlist.R
import com.bridgelabs.userlist.model.User

class DisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        val editUserName = findViewById<TextView>(R.id.user_name)
        val nameHolder = intent.getSerializableExtra("UserInfo") as User
        editUserName.setText(nameHolder.name)

        val editUserNumber = findViewById<TextView>(R.id.user_number)
        val numberHolder = intent.getSerializableExtra("UserInfo") as User
        editUserNumber.setText(numberHolder.mobileNumber)
    }
}
