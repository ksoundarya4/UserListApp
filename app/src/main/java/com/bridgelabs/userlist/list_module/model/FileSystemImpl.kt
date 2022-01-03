/**
 * UserListApp
 * @description FileSystemImpl implements FileSystem
 * @file FileSystemImpl.kt
 * @author ksoundarya4
 * @version 1.0
 * @since 27/01/2020
 */
package com.bridgelabs.userlist.list_module.model

import android.content.Context
import android.util.Log
import com.bridgelabs.userlist.list_module.model.FileSystem
import com.bridgelabs.userlist.list_module.model.User
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

class FileSystemImpl(private val context: Context) : FileSystem {
    private val objectMapper = jacksonObjectMapper()

    override fun readUser(): List<User> {
        val inputStream = context.assets.open("user.json")
        return objectMapper.readValue<ArrayList<User>>(inputStream)
    }

    override fun saveUser(user: User) {
            val inputStream = context.assets.open("user.json")
            val userList =objectMapper.readValue<ArrayList<User>>(inputStream)
            userList.add(user)
            objectMapper.writeValueAsString(userList)
    }
}