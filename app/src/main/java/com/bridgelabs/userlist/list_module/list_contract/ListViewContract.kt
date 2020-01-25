package com.bridgelabs.userlist.list_module.list_contract

import com.bridgelabs.userlist.model.User

interface ListViewContract {
    fun initListView(arrayList: List<User>)
    fun navigateToAddActivity()
}