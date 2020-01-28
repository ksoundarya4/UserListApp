/**
 * UserListApp
 * @description ListPresenterImpl implements
 * the ListPresenterContract.
 * @file ListPresenterImpl.kt
 * @author ksoundarya4
 * @version 1.0
 * @since 26/01/2020
 */
package com.bridgelabs.userlist.list_module.presenter

import com.bridgelabs.userlist.list_module.list_contract.ListModelContract
import com.bridgelabs.userlist.list_module.list_contract.ListPresenterContract
import com.bridgelabs.userlist.list_module.list_contract.ListViewContract
import com.bridgelabs.userlist.list_module.model.User

class ListPresenterImpl(val view: ListViewContract, val model: ListModelContract) :
    ListPresenterContract {

    override fun initUI() {
        val userList = model.getListOfUsers()
        view.initListView(userList)
    }

    override fun onAddButtonClick() {
        view.navigateToAddActivity()
    }

    override fun onItemClick(position: Int) {
        val userList = model.getListOfUsers()
        val clickedUser: User = userList[position]
        view.navigateToDetailActivity(clickedUser)
    }
}