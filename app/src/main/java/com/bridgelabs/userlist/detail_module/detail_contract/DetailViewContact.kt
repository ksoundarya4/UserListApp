/**
 * UserListApp
 * @description DetailViewContact interface to display user
 * user information and return the results to list activity
 * if user is removed from list.
 * @file DetailViewContact.kt
 * @author ksoundarya4
 * @version 1.0
 * @since 26/01/2020
 */
package com.bridgelabs.userlist.detail_module.detail_contract

import com.bridgelabs.userlist.list_module.model.User

interface DetailViewContact {
    fun initDetailView()
    fun returnDeleteResult(user : User)
}