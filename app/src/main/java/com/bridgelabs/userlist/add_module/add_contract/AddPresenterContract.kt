package com.bridgelabs.userlist.add_module.add_contract

import com.bridgelabs.userlist.util.User

interface AddPresenterContract {
    fun initAddUserUI()
    fun saveUserToList(user : User)
}