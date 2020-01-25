package com.bridgelabs.userlist.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.bridgelabs.userlist.R
import com.bridgelabs.userlist.R.id.user_name
import com.bridgelabs.userlist.model.User
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.File


class MainActivity : AppCompatActivity() {

    // Array of strings...
    val simpleList: ListView by lazy { findViewById<ListView>(R.id.simpleListView) }

    /**To read array of user json file from device*/
    private val objectMapper = jacksonObjectMapper()
    val file = File("/data/data/com.bridgelabs.userlist/files/user.json")

    val userList: Array<User> = objectMapper.readValue(file)

    /**To obtain the position of list view */
    var listPosition: Int = 0

    @SuppressLint("SdCardPath")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**To add User to userList*/
        val addButton = findViewById<Button>(R.id.add_user)
        addButton.setOnClickListener {
            val addActivityIntent = Intent(this, AddActivity::class.java)
            startActivity(addActivityIntent)
        }

        /**To get user names into array list of userNames */
        val userNames = ArrayList<String>()
        for (user in userList) {
            userNames.add(user.name)
        }

        /**To hold list of user names*/
        val arrayAdapter = ArrayAdapter<String>(
            this,
            R.layout.activity_listview,
            user_name, userNames
        )
        simpleList.adapter = arrayAdapter

        simpleList.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->

                // Getting userList click value into String variable.
                // Getting userList click value into String variable.
                val userListViewClickedValue: User = userList[position]
                Log.d("User", userListViewClickedValue.toString())
                listPosition = position
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
