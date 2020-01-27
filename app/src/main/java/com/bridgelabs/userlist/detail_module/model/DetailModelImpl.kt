package com.bridgelabs.userlist.detail_module.model

import com.bridgelabs.userlist.detail_module.detail_contract.DetailModelContract
import com.bridgelabs.userlist.list_module.list_contract.ListModelContract
import com.bridgelabs.userlist.list_module.model.ListModelContractImpl
import com.bridgelabs.userlist.util.User

class DetailModelImpl(private var userList: ArrayList<User>) : DetailModelContract,
    ListModelContract {

    override fun addUser(user: User) {

    }

    override fun deleteUser(user: User) {
        userList.remove(user)
    }

    override fun updateUser(user: User) {

    }

    override fun getListOfUsers(): List<User> {
        return userList
    }

}