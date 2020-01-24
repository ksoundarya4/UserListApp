package com.bridgelabs.userlist.view

import android.annotation.SuppressLint
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

    @SuppressLint("SdCardPath")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val objectMapper = jacksonObjectMapper()
        val userList: Array<User> =
            objectMapper.readValue(File("/data/data/com.bridgelabs.userlist/files/user.json"))

        val userNames = ArrayList<String>()
        for (user in userList) {
         userNames.add(user.name)
                    }
        val arrayAdapter = ArrayAdapter<String>(
            this,
            R.layout.activity_listview,
            R.id.name, userNames
        )
        simpleList.adapter = arrayAdapter
    }
}
