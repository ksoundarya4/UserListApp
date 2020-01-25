/**
 * UserListApp
 * @purpose To get user name and user mobile number input
 * from user and add them to user list on clicking save button.
 * @file AddActivity.kt
 * @author ksoundarya4
 * @version 1.0
 * @since 25/01/2020
 */
package com.bridgelabs.userlist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.bridgelabs.userlist.R

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val editUserName = findViewById<EditText>(R.id.add_user_name)
        val userName = editUserName.text.toString()

        val editUserNumber = findViewById<EditText>(R.id.add_user_mobile_number)
        val userNumber = editUserNumber.text.toString()

        val saveButton = findViewById<Button>(R.id.save_user)
        saveButton.setOnClickListener {
            val main = MainActivity()

        }
    }
}
