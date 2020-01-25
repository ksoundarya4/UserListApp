package com.bridgelabs.userlist.list_module.list_contract

import com.bridgelabs.userlist.model.User

interface ListModelContract {
    fun addUser(user: User)
    fun updateUser(user: User)
    fun deleteUser(user: User)
    fun getListOfUsers() : List<User>
}