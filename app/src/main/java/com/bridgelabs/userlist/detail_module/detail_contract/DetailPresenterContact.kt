package com.bridgelabs.userlist.detail_module.detail_contract

import android.view.View
import com.bridgelabs.userlist.util.User
import java.io.InputStream

interface DetailPresenterContact {
    fun initDetailUI()
    fun onDeleteButtonClick(user : User)
}