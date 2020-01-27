package com.bridgelabs.userlist.add_module.add_contract

import com.bridgelabs.userlist.util.User

interface AddViewContract {
    fun saveUser()
    fun returnSaveResult(user : User)
}