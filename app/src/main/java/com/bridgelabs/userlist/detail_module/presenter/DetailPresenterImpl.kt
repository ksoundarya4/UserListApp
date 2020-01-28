/**
 * UserListApp
 * @description DetailPresenterImpl implements
 * the DetailPresenterContract.
 * @file DetailPresenterImpl.kt
 * @author ksoundarya4
 * @version 1.0
 * @since 26/01/2020
 */
package com.bridgelabs.userlist.detail_module.presenter

import com.bridgelabs.userlist.detail_module.detail_contract.DetailPresenterContact
import com.bridgelabs.userlist.detail_module.detail_contract.DetailViewContact
import com.bridgelabs.userlist.list_module.list_contract.ListModelContract
import com.bridgelabs.userlist.list_module.model.User

class DetailPresenterImpl(var view: DetailViewContact, val model: ListModelContract) :
    DetailPresenterContact {

    override fun initDetailUI() {
        view.initDetailView()
    }

    override fun onDeleteButtonClick(user : User) {
        model.deleteUser(user)
    }
}