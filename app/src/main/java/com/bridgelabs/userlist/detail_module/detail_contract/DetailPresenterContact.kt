package com.bridgelabs.userlist.detail_module.detail_contract

import android.view.View

interface DetailPresenterContact {
    fun initDetailUI()
    fun onDeleteButtonClick(userName : String , userNumber : String)
}