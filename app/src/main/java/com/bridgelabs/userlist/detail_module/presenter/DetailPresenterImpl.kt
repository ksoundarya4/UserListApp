package com.bridgelabs.userlist.detail_module.presenter

import com.bridgelabs.userlist.detail_module.detail_contract.DetailModelContract
import com.bridgelabs.userlist.detail_module.detail_contract.DetailPresenterContact
import com.bridgelabs.userlist.detail_module.detail_contract.DetailViewContact
import com.bridgelabs.userlist.util.FileSystem
import com.bridgelabs.userlist.util.User
import java.io.InputStream


class DetailPresenterImpl(var view: DetailViewContact, val model: DetailModelContract) :
    DetailPresenterContact {

    override fun initDetailUI() {
        view.initDetailView()
    }

    override fun onDeleteButtonClick(userName: String, userNumber: String) {
       val user = User(userName,userNumber)
        model.deleteUser(user)
    }

    override fun getUserList(inputStream: InputStream): List<User> {
        val fileSystem = FileSystem()
        return fileSystem.readUser(inputStream)
    }

}