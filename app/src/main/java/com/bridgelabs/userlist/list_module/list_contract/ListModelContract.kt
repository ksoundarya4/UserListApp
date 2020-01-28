/**
 * UserListApp
 * @description ListModelContact interface to
 * perform data logic on user list.
 * @file ListModelContact.kt
 * @author ksoundarya4
 * @version 1.0
 * @since 26/01/2020
 */
package com.bridgelabs.userlist.list_module.list_contract

import com.bridgelabs.userlist.list_module.model.User

interface ListModelContract {
    fun addUser(user: User)
    fun updateUser(user : User)
    fun deleteUser(user: User)
    fun getListOfUsers() : List<User>
}