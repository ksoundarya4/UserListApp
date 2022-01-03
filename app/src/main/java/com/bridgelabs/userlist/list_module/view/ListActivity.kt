/**
 * UserListApp
 * @description ListActivity implements
 * the ListViewContract.
 * @file ListActivity.kt
 * @author ksoundarya4
 * @version 1.0
 * @since 26/01/2020
 */
package com.bridgelabs.userlist.list_module.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bridgelabs.userlist.R
import com.bridgelabs.userlist.add_module.view.AddActivity
import com.bridgelabs.userlist.detail_module.view.DetailActivity
import com.bridgelabs.userlist.list_module.list_contract.ListPresenterContract
import com.bridgelabs.userlist.list_module.list_contract.ListViewContract
import com.bridgelabs.userlist.list_module.model.ListModelContractImpl
import com.bridgelabs.userlist.list_module.model.User
import com.bridgelabs.userlist.list_module.presenter.ListPresenterImpl
import com.bridgelabs.userlist.list_module.model.FileSystemImpl
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListActivity : AppCompatActivity(), ListViewContract {
    private lateinit var arrayAdapter : UserListAdapter
    private val usersListView: ListView by lazy { findViewById<ListView>(R.id.listview_users) }
    private val presenterContract: ListPresenterContract by lazy {
        ListPresenterImpl(
            this,
            ListModelContractImpl(fileSystem = FileSystemImpl(
                this
            )
            )
        )
    }
    private val PICK_USER__ADD_REQUEST = 1
    private val PICK_USER_DELETE_REQUEST = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        presenterContract.initUI()

        val addButton = findViewById<FloatingActionButton>(R.id.add_user_button)
        addButton.setOnClickListener { presenterContract.onAddButtonClick() }

        usersListView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            presenterContract.onItemClick(position)

        }
    }

    override fun initListView(arrayList: List<User>) {
        arrayAdapter = UserListAdapter(this, arrayList)
        usersListView.adapter = arrayAdapter
    }

    override fun navigateToAddActivity() {
        val addActivityIntent = Intent(this, AddActivity::class.java)
        startActivityForResult(addActivityIntent, PICK_USER__ADD_REQUEST)
    }

    override fun navigateToDetailActivity(clickedUser: User) {
        val addDetailIntent =
            Intent(this, DetailActivity::class.java).apply { putExtra("UserInfo", clickedUser) }
        startActivityForResult(addDetailIntent, PICK_USER_DELETE_REQUEST)
        Toast.makeText(this, clickedUser.toString(), Toast.LENGTH_SHORT).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {

                val user = data?.getSerializableExtra("isAdded") as User
                arrayAdapter.add(user)
                presenterContract.initUI()
            }
        }
        if (requestCode == 2) {
            if (resultCode == Activity.RESULT_OK) {
                val user = data?.getSerializableExtra("deleteUser") as User
                arrayAdapter.remove(user)
                presenterContract.initUI()
            }
        }
    }
}