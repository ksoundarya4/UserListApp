package com.bridgelabs.userlist

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    // Array of strings...
    private val simpleList: ListView by lazy { findViewById<ListView>(R.id.simpleListView) }
    var countryList =
        arrayOf("India", "China", "australia", "Portugle", "America", "NewZealand")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var arrayAdapter = ArrayAdapter<String>(
            this,
            R.layout.activity_listview,
            R.id.textView, countryList
        )
        simpleList.adapter = arrayAdapter
    }
}
