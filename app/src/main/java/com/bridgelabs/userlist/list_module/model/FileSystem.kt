package com.bridgelabs.userlist.list_module.model

import com.bridgelabs.userlist.list_module.model.util.User

interface FileSystem {
    fun readUser(): List<User>
    fun saveUser()
}