package com.bridgelabs.userlist.list_module.list_contract

import com.bridgelabs.userlist.util.User
import java.io.InputStream

interface ListPresenterContract {
    fun initUI()
    fun onAddButtonClick()
    fun onItemClick(position : Int)
    fun getUserList(inputStream: InputStream) : List<User>
}
