package com.bridgelabs.userlist.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.bridgelabs.userlist.R
import com.bridgelabs.userlist.model.FileSystem
import com.bridgelabs.userlist.model.User
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import kotlinx.android.synthetic.main.activity_listview.*
import java.io.File


class MainActivity : AppCompatActivity(), View {

    // Array of strings...
    private val simpleList: ListView by lazy { findViewById<ListView>(R.id.simpleListView) }

    private val PICK_USER_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**To add User to userList*/
        val addButton = findViewById<Button>(R.id.add_user)
        addButton.setOnClickListener {
            val addActivityIntent = Intent(this, AddActivity::class.java)
            startActivityForResult(addActivityIntent, PICK_USER_REQUEST)
        }



        /**To read list of user*/
        val fileSystem = FileSystem()
        val userList: ArrayList<User> = fileSystem.readUser(assets.open("user.json"))

        /**To get user names into array list of userNames */
        val userNames = ArrayList<String>()
        for (user in userList) {
            userNames.add(user.name)
        }

        /**To hold list of user names*/
        val arrayAdapter = ArrayAdapter<String>(
            this,
            R.layout.activity_listview,
            R.id.user_name, userNames
        )
        simpleList.adapter = arrayAdapter

        simpleList.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->

                // Getting userList click value into String variable.
                // Getting userList click value into String variable.
                val userListViewClickedValue: User = userList[position]
                Log.d("User", userListViewClickedValue.toString())


                Log.d("Position", position.toString())

                val displayActivityIntent = Intent(this, DisplayActivity::class.java).apply {
                    putExtra(
                        "UserInfo",
                        userListViewClickedValue
                    )
                }
                startActivity(displayActivityIntent)
                Toast.makeText(this, userList[position].toString(), Toast.LENGTH_SHORT).show()
            }
    }
}
