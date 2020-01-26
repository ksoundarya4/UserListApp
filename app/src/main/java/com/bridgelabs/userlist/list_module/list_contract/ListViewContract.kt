package com.bridgelabs.userlist.list_module.list_contract

import com.bridgelabs.userlist.list_module.model.User

interface ListViewContract {
    fun initListView(arrayList: List<User>)
    fun navigateToAddActivity()
}