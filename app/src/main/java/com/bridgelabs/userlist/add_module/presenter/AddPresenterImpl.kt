package com.bridgelabs.userlist.add_module.presenter

import com.bridgelabs.userlist.add_module.add_contract.AddPresenterContract
import com.bridgelabs.userlist.add_module.add_contract.AddViewContract
import com.bridgelabs.userlist.list_module.model.ListModelContractImpl
import com.bridgelabs.userlist.util.User

class AddPresenterImpl(val view: AddViewContract, val model: ListModelContractImpl) :
    AddPresenterContract {

    override fun initAddUserUI() {
        view.saveUser()
    }

    override fun saveUserToList(user: User) {
        model.addUser(user)
        view.returnSaveResult(user)
    }
}