package com.bridgelabs.userlist.add_module.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bridgelabs.userlist.R
import com.bridgelabs.userlist.list_module.list_contract.ListPresenterContract
import com.bridgelabs.userlist.list_module.list_contract.ListViewContract
import com.bridgelabs.userlist.list_module.model.ListModelContractImpl
import com.bridgelabs.userlist.list_module.presenter.ListPresenterImpl

class AddActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
    }
}
