package com.bridgelabs.userlist.list_module.model

import com.bridgelabs.userlist.list_module.list_contract.ListModelContract

class ListModelContractImpl : ListModelContract {
    val userList = ArrayList<User>()
    override fun addUser(user: User) {
        userList.add(user)
    }

    override fun updateUser(user: User) {

    }

    override fun deleteUser(user: User) {
        userList.remove(user)
    }

    override fun getListOfUsers(): List<User> {
        return userList
    }
}