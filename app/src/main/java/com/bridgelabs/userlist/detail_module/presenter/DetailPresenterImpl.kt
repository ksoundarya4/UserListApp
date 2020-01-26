package com.bridgelabs.userlist.detail_module.presenter

import android.view.View
import com.bridgelabs.userlist.detail_module.detail_contract.DetailModelContract
import com.bridgelabs.userlist.detail_module.detail_contract.DetailPresenterContact
import com.bridgelabs.userlist.detail_module.detail_contract.DetailViewContact
import com.bridgelabs.userlist.util.FileSystem
import com.bridgelabs.userlist.view.DisplayActivity

class DetailPresenterImpl(var view: DetailViewContact, val model: DetailModelContract) :
    DetailPresenterContact {

    override fun initDetailUI() {
        view.initDetailView()
    }

    override fun onDeleteButtonClick(userName: String, userNumber: String) {
        val userList = fileSystem.readUser(view.assest)
        model.deleteUser(user)
    }

}