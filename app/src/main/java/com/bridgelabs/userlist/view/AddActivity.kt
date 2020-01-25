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

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.bridgelabs.userlist.Presenter.AddUser
import com.bridgelabs.userlist.R


class AddActivity : AppCompatActivity(),View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)


        val saveButton = findViewById<Button>(R.id.save_user)
        saveButton.setOnClickListener {

            val addUser = AddUser()
            val userList = addUser.addUserToList()

            val returnIntent = Intent()
            returnIntent.putExtra("Add_User_esult", userList)
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }
    }
}
