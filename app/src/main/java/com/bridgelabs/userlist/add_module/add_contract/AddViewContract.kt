/**
 * UserListApp
 * @description AddViewContact interface to add user
 * to list and return the results to list activity.
 * @file AddViewContact.kt
 * @author ksoundarya4
 * @version 1.0
 * @since 26/01/2020
 */
package com.bridgelabs.userlist.add_module.add_contract

import com.bridgelabs.userlist.list_module.model.User

interface AddViewContract {
    fun saveUser()
    fun returnSaveResult(user : User)
}