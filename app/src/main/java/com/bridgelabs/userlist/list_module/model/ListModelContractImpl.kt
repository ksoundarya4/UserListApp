package com.bridgelabs.userlist.list_module.model

import com.bridgelabs.userlist.list_module.list_contract.ListModelContract
import com.bridgelabs.userlist.util.User

class ListModelContractImpl(userList : ArrayList<User>) : ListModelContract {

    override fun addUser(user: User) {

    }

    override fun updateUser(user: User) {

    }

    override fun deleteUser(user: User) {

    }

    override fun getListOfUsers(): List<User> {
        return emptyList()
    }
}