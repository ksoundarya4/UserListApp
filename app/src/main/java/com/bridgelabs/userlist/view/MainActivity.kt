package com.bridgelabs.userlist.view

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.bridgelabs.userlist.R
import com.bridgelabs.userlist.model.User
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.File


class MainActivity : AppCompatActivity() {

    // Array of strings...
    private val simpleList: ListView by lazy { findViewById<ListView>(R.id.simpleListView) }
    var userName = ArrayList<String>()
    var mobileNumber = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val objectMapper = jacksonObjectMapper()
        val userList: ArrayList<User> =
            objectMapper.readValue(File("/home/user/AndroidStudioProjects/UserList/app/src/main/java/com/bridgelabs/userlist/model/user.json"))

        val arrayAdapter = ArrayAdapter<User>(
            this,
            R.layout.activity_listview,
            R.id.name, userList
        )
        simpleList.adapter = arrayAdapter
    }
}
