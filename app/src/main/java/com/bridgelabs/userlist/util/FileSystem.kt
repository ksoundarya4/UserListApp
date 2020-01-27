package com.bridgelabs.userlist.util

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.File
import java.io.InputStream

class FileSystem {
    private val objectMapper = jacksonObjectMapper()

    fun readUser(file: InputStream): List<User> {
        val userList: ArrayList<User> = objectMapper.readValue(file)
        return userList
    }

    fun saveUser(file: File, userList : List<User>) {
        try{
            objectMapper.writeValue(file,userList)
        }catch(exception : Exception){
            println("write to file failed")
            exception.printStackTrace()
        }
    }
}