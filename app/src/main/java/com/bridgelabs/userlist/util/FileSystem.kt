package com.bridgelabs.userlist.util

import android.content.Context
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

interface FileSystem {
    fun readUser(): List<User>
    fun saveUser()
}