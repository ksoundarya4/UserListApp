/**
 * UserListApp
 * @description AddPresenterContact interface to initialize
 * Add Activity and to add users to list of users.
 * @file AddPresenterContact.kt
 * @author ksoundarya4
 * @version 1.0
 * @since 26/01/2020
 */
package com.bridgelabs.userlist.add_module.add_contract

import com.bridgelabs.userlist.list_module.model.User

interface AddPresenterContract {
    fun initAddUserUI()
    fun saveUserToList(user : User)
}