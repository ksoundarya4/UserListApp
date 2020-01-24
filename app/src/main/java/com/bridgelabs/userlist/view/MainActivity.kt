package com.bridgelabs.userlist.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
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
    private val simpleList: ListView by lazy { findViewById<ListView>(R.id.simpleListView) }

    @SuppressLint("SdCardPath")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**To read array of user json file from device*/
        val objectMapper = jacksonObjectMapper()
        val userList: Array<User> =
            objectMapper.readValue(File("/data/data/com.bridgelabs.userlist/files/user.json"))

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
                val displayActivityIntent = Intent(this, DisplayActivity::class.java)
                startActivity(displayActivityIntent)
                Toast.makeText(this, userList[position].toString(), Toast.LENGTH_SHORT).show()
            }

//        val userInfo : TextView = findViewById(user_name)
//        userInfo.setOnClickListener{userCLick()}
    }

    private fun userCLick() {
        Toast.makeText(
            this, "Text clicked",
            Toast.LENGTH_SHORT
        ).show()
    }
}
