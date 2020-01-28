/**
 * UserListApp
 * @description DetailActivity implements
 * the DetailViewContract.
 * @file DetailActivity.kt
 * @author ksoundarya4
 * @version 1.0
 * @since 26/01/2020
 */
package com.bridgelabs.userlist.detail_module.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.bridgelabs.userlist.R
import com.bridgelabs.userlist.detail_module.detail_contract.DetailPresenterContact
import com.bridgelabs.userlist.detail_module.detail_contract.DetailViewContact
import com.bridgelabs.userlist.detail_module.presenter.DetailPresenterImpl
import com.bridgelabs.userlist.list_module.model.ListModelContractImpl
import com.bridgelabs.userlist.list_module.view.ListActivity
import com.bridgelabs.userlist.list_module.model.FileSystemImpl
import com.bridgelabs.userlist.list_module.model.User

class DetailActivity : AppCompatActivity(), DetailViewContact {

    private val userName by lazy {
        findViewById<TextView>(R.id.display_user_name)
    }
    private val userNumber by lazy {
        findViewById<TextView>(R.id.display_user_number)
    }

    lateinit var user : User

    private val presenterContract: DetailPresenterContact by lazy {
        DetailPresenterImpl(
            this,
            ListModelContractImpl(
                fileSystem = FileSystemImpl(
                    context = this
                )
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        presenterContract.initDetailUI()

        val deleteButton = findViewById<Button>(R.id.delete_user)
        deleteButton.setOnClickListener { view ->
            presenterContract.onDeleteButtonClick(user)
        }
    }

    override fun initDetailView() {
       user = intent.getSerializableExtra("UserInfo") as User
        userName.setText(user.name)
        userNumber.setText(user.mobileNumber)

    }

    override fun returnDeleteResult(user: User) {
        val deleteIntent = Intent(applicationContext, ListActivity::class.java).apply {
            putExtra("deltedUser", user )
        }
        setResult(Activity.RESULT_OK, deleteIntent)
        finish()
    }
}