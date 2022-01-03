/**
 * UserListApp
 * @description ListModelContractImpl that implements
 * ListModelContract.
 * @file ListModelContactImpl.kt
 * @author ksoundarya4
 * @version 1.0
 * @since 26/01/2020
 */
package com.bridgelabs.userlist.list_module.model

import com.bridgelabs.userlist.list_module.list_contract.ListModelContract

class ListModelContractImpl(private val fileSystem: FileSystem) : ListModelContract {

    override fun addUser(user: User) {
        val userList = fileSystem.readUser() as ArrayList<User>
        userList.add(user)
        fileSystem.saveUser(user)
    }

    override fun updateUser(user : User) {

    }

    override fun deleteUser(user: User) {
        val userList = fileSystem.readUser() as ArrayList<User>
        userList.remove(user)
        fileSystem.saveUser(user)
    }

    override fun getListOfUsers(): List<User> {
        return fileSystem.readUser()
    }
}