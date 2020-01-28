/**
 * UserListApp
 * @description DetailPresenterContact interface to initialize
 * Display Activity and to delete users to list of users.
 * @file DetailPresenterContact.kt
 * @author ksoundarya4
 * @version 1.0
 * @since 26/01/2020
 */
package com.bridgelabs.userlist.detail_module.detail_contract

import com.bridgelabs.userlist.list_module.model.User

interface DetailPresenterContact {
    fun initDetailUI()
    fun onDeleteButtonClick(user : User)
}