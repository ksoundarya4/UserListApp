package com.bridgelabs.userlist.list_module.presenter

import com.bridgelabs.userlist.list_module.list_contract.ListModelContract
import com.bridgelabs.userlist.list_module.list_contract.ListPresenterContract
import com.bridgelabs.userlist.list_module.list_contract.ListViewContract
import com.bridgelabs.userlist.util.FileSystem
import com.bridgelabs.userlist.util.User
import java.io.InputStream

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