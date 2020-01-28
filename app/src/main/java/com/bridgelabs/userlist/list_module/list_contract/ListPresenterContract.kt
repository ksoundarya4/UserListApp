/**
 * UserListApp
 * @description ListPresenterContact interface to initialize
 * List Activity , Add Activity and Display Activity
 * @file ListPresenterContact.kt
 * @author ksoundarya4
 * @version 1.0
 * @since 26/01/2020
 */
package com.bridgelabs.userlist.list_module.list_contract

interface ListPresenterContract {
    fun initUI()
    fun onAddButtonClick()
    fun onItemClick(position: Int)
}