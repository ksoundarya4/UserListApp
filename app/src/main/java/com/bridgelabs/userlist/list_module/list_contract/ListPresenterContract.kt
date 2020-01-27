package com.bridgelabs.userlist.list_module.list_contract

interface ListPresenterContract {
    fun initUI()
    fun onAddButtonClick()
    fun onItemClick(position: Int)
}
