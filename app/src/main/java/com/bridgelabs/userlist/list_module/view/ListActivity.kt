package com.bridgelabs.userlist.list_module.view

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.bridgelabs.userlist.R
import com.bridgelabs.userlist.list_module.list_contract.ListPresenterContract
import com.bridgelabs.userlist.list_module.list_contract.ListViewContract
import com.bridgelabs.userlist.list_module.model.ListModelContractImpl
import com.bridgelabs.userlist.list_module.model.User
import com.bridgelabs.userlist.list_module.presenter.ListPresenterImpl
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListActivity : AppCompatActivity(), ListViewContract {

    private val usersListView: ListView by lazy { findViewById<ListView>(R.id.listview_users) }
    private val presenterContract: ListPresenterContract by lazy {
        ListPresenterImpl(
            this,
            ListModelContractImpl()
        )
    }
    private val addButton = findViewById<FloatingActionButton>(R.id.add_user_button)
    private val PICK_USER_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        presenterContract.initUI()
    }

    override fun initListView(arrayList: List<User>) {
        val arrayAdapter =
            ArrayAdapter<User>(this, R.layout.activity_listview, R.id.user_name, arrayList)
        usersListView.adapter = arrayAdapter
    }

    override fun navigateToAddActivity() {
        val addActivityIntent = Intent(this, AddActivity::class.java)
        startActivityForResult(addActivityIntent, PICK_USER_REQUEST)
    }
}
