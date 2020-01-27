package com.bridgelabs.userlist.list_module.model

import com.bridgelabs.userlist.list_module.list_contract.ListModelContract
import com.bridgelabs.userlist.util.FileSystem
import com.bridgelabs.userlist.util.User
import java.io.File
import java.math.MathContext

class ListModelContractImpl(private val fileSystem: FileSystem) : ListModelContract {

    override fun addUser(user: User) {
        val userList = fileSystem.readUser() as ArrayList<User>
        userList.add(user)
    }

    override fun updateUser(userList: List<User>) {
        val file = File("/home/user/AndroidStudioProjects/UserList/app/src/main/assets/user.json")
        fileSystem.saveUser(file, userList)
    }

    override fun deleteUser(user: User) {
        val userList = fileSystem.readUser() as ArrayList<User>
        userList.remove(user)
    }

    override fun getListOfUsers(): List<User> {
        return fileSystem.readUser()
    }


}