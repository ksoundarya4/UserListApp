/**
 * UserListApp
 * @description ListViewContact interface to initialize
 * list view of user list.
 * @file ListViewContact.kt
 * @author ksoundarya4
 * @version 1.0
 * @since 26/01/2020
 */
package com.bridgelabs.userlist.list_module.list_contract

import com.bridgelabs.userlist.list_module.model.User

interface ListViewContract {
    fun initListView(arrayList: List<User>)
    fun navigateToAddActivity()
    fun navigateToDetailActivity(clickedUser: User)
}