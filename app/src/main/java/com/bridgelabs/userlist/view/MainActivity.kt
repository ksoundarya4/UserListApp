package com.bridgelabs.userlist.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bridgelabs.userlist.R
import com.bridgelabs.userlist.R.id.user_name
import com.bridgelabs.userlist.model.User
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.File


class MainActivity : AppCompatActivity() {

    // Array of strings...
    private val simpleList: ListView by lazy { findViewById<ListView>(R.id.simpleListView) }

    /**To read array of user json file from device*/
  private val objectMapper = jacksonObjectMapper()
    @SuppressLint("SdCardPath")
    private val userList: Array<User> =
        objectMapper.readValue(File("/data/data/com.bridgelabs.userlist/files/user.json"))

    @SuppressLint("SdCardPath")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
