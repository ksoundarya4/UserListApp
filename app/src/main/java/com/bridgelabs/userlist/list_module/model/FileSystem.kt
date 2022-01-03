/**
 * UserListApp
 * @description FileSystem interface that accepts context
 * and perform reading of userList from .json file and
 * saving modified list to .json file.
 * @file FileSystem.kt
 * @author ksoundarya4
 * @version 1.0
 * @since 27/01/2020
 */
package com.bridgelabs.userlist.list_module.model

interface FileSystem {
    fun readUser(): List<User>
    fun saveUser(user: User)
}