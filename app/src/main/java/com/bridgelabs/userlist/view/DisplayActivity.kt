package com.bridgelabs.userlist.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
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

        val deleteButton  = findViewById<Button>(R.id.delete_user)

        deleteButton.setOnClickListener(View.OnClickListener {
            val main = MainActivity()
            val user: ListView = main.findViewById(R.id.simpleListView)
            user
        })
    }
}
