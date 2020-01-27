package com.bridgelabs.userlist.detail_module.detail_contract

import com.bridgelabs.userlist.util.User
import java.io.InputStream

interface DetailPresenterContact {
    fun initDetailUI()
    fun onDeleteButtonClick(userName : String , userNumber : String)
    fun getUserList(inputStream: InputStream) : List<User>
}