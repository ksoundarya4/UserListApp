package com.bridgelabs.userlist.detail_module.model

import com.bridgelabs.userlist.detail_module.detail_contract.DetailModelContract
import com.bridgelabs.userlist.util.User

class DetailModelImpl(private var userList: ArrayList<User>) : DetailModelContract {

    override fun deleteUser(user: User) {
        userList.remove(user)
    }

    override fun getListOfUsers(): List<User> {
        return userList
    }
}