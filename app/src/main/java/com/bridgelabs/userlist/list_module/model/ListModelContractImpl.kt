package com.bridgelabs.userlist.list_module.model

import com.bridgelabs.userlist.list_module.list_contract.ListModelContract
import com.bridgelabs.userlist.util.FileSystem
import com.bridgelabs.userlist.util.User
import java.io.File

class ListModelContractImpl(private val fileSystem: FileSystem) : ListModelContract {

    override fun addUser(user: User) {
        val userList = fileSystem.readUser() as ArrayList<User>
        userList.add(user)
        fileSystem.saveUser()
    }

    override fun updateUser(user : User) {

    }

    override fun deleteUser(user: User) {
        val userList = fileSystem.readUser() as ArrayList<User>
        userList.remove(user)
        fileSystem.saveUser( )
    }

    override fun getListOfUsers(): List<User> {
        return fileSystem.readUser()
    }
}