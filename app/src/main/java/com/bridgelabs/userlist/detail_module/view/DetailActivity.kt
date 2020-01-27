package com.bridgelabs.userlist.detail_module.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.bridgelabs.userlist.R
import com.bridgelabs.userlist.detail_module.detail_contract.DetailPresenterContact
import com.bridgelabs.userlist.detail_module.detail_contract.DetailViewContact
import com.bridgelabs.userlist.detail_module.model.DetailModelImpl
import com.bridgelabs.userlist.detail_module.presenter.DetailPresenterImpl
import com.bridgelabs.userlist.util.User
import java.io.InputStream

class DetailActivity : AppCompatActivity(), DetailViewContact {

    private val userName = findViewById<TextView>(R.id.display_user_name)
    private val userNumber = findViewById<TextView>(R.id.display_user_number)

    private val presenterContract: DetailPresenterContact by lazy {
        DetailPresenterImpl(
            this,
            DetailModelImpl()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        presenterContract.initDetailUI()

        val deleteButton = findViewById<Button>(R.id.delete_user)
        deleteButton.setOnClickListener { view ->
            presenterContract.onDeleteButtonClick(
                userName.toString(),
                userNumber.toString()
            )
        }
    }

    override fun initDetailView() {
        val nameHolder = intent.getSerializableExtra("UserInfo") as User
        val numberHolder = intent.getSerializableExtra("UserInfo") as User
        userName.setText(nameHolder.name)
        userNumber.setText(numberHolder.mobileNumber)
    }

    fun getAssets() {
        this.assets
    }
}


