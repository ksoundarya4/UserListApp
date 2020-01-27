package com.bridgelabs.userlist.detail_module.presenter

import android.view.View
import com.bridgelabs.userlist.detail_module.detail_contract.DetailPresenterContact
import com.bridgelabs.userlist.detail_module.detail_contract.DetailViewContact
import com.bridgelabs.userlist.list_module.list_contract.ListModelContract
import com.bridgelabs.userlist.util.User


class DetailPresenterImpl(var view: DetailViewContact, val model: ListModelContract) :
    DetailPresenterContact {

    override fun initDetailUI() {
        view.initDetailView()
    }

    override fun onDeleteButtonClick(user : User) {
        model.deleteUser(user)
    }
}