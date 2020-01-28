/**
 * UserListApp
 * @description AddActivity implements
 * the AddViewContract.
 * @file AddActivity.kt
 * @author ksoundarya4
 * @version 1.0
 * @since 26/01/2020
 */
package com.bridgelabs.userlist.add_module.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.bridgelabs.userlist.R
import com.bridgelabs.userlist.add_module.add_contract.AddPresenterContract
import com.bridgelabs.userlist.add_module.add_contract.AddViewContract
import com.bridgelabs.userlist.add_module.presenter.AddPresenterImpl
import com.bridgelabs.userlist.list_module.model.ListModelContractImpl
import com.bridgelabs.userlist.list_module.view.ListActivity
import com.bridgelabs.userlist.list_module.model.FileSystemImpl
import com.bridgelabs.userlist.list_module.model.User

class AddActivity : AppCompatActivity(), AddViewContract {

    val editUserName by lazy {
        findViewById<EditText>(R.id.add_user_name)
    }

    val editUserNumber by lazy {
        findViewById<EditText>(R.id.add_user_mobile_number)
    }

    val presenterContract: AddPresenterContract by lazy {
        AddPresenterImpl(this, ListModelContractImpl(fileSystem = FileSystemImpl(
            this
        )
        ))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val saveButton = findViewById<Button>(R.id.save_user)
        saveButton.setOnClickListener {
            presenterContract.initAddUserUI()
        }
    }

    override fun saveUser() {
        val userName = editUserName.text.toString()
        val userNumber = editUserNumber.text.toString()
        val user =
            User(userName, userNumber)
        presenterContract.saveUserToList(user)
    }

    override fun returnSaveResult(user: User) {
        val saveIntent = Intent(
            applicationContext,
            ListActivity::class.java
        ).apply {
            putExtra("isAdded", user)
        }
        setResult(Activity.RESULT_OK, saveIntent)
        finish()
    }
}