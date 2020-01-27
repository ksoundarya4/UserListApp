package com.bridgelabs.userlist.detail_module.detail_contract

import com.bridgelabs.userlist.util.User

interface DetailModelContract{
    fun deleteUser(user : User)
    fun getListOfUsers() : List<User>
}