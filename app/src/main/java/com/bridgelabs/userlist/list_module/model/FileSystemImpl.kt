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

    override fun saveUser() {
        try {
            val assertFileDescriptor = context.assets.openFd("user.json")
            val file = assertFileDescriptor.createOutputStream()
            val userList = readUser() as ArrayList<User>
            objectMapper.writeValue(file, userList)
        } catch (exception: Exception) {
            println("write to file failed")
            exception.printStackTrace()
        }
    }
}