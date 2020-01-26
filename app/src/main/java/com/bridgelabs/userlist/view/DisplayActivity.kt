/**
 * UserListApp
 * @purpose To display user details i.e user name and
 * user mobile number in new activity and to perform
 * delete that user from user list.
 * @file DisplayActivity.kt
 * @author ksoundarya4
 * @version 1.0
 * @since 24/01/2020
 */
package com.bridgelabs.userlist.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bridgelabs.userlist.R
import com.bridgelabs.userlist.detail_module.detail_contract.DetailViewContact
import com.bridgelabs.userlist.model.User

class DisplayActivity : AppCompatActivity(), DetailViewContact {
    override fun initDetailView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        val editUserName = findViewById<TextView>(R.id.display_user_name)
        val nameHolder = intent.getSerializableExtra("UserInfo") as User
        editUserName.setText(nameHolder.name)

        val editUserNumber = findViewById<TextView>(R.id.display_user_number)
        val numberHolder = intent.getSerializableExtra("UserInfo") as User
        editUserNumber.setText(numberHolder.mobileNumber)

        val deleteButton = findViewById<Button>(R.id.delete_user)

        deleteButton.setOnClickListener(View.OnClickListener {

        })
    }
}
