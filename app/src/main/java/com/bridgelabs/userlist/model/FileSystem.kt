/**
 * UserListAPP
 * @purpose TO create a file system class which
 * can write to .json file and read from .json file
 * @file FileSystem.kt
 * @author ksoundarya4
 * @version 1.0
 * @since 25/01/2020
 */
package com.bridgelabs.userlist.model

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.File
import java.io.InputStream
import java.lang.Exception

class FileSystem : Model {

    private val objectMapper = jacksonObjectMapper()

    fun readUser(file: InputStream): ArrayList<User> {
        val userList: ArrayList<User> = objectMapper.readValue(file)
        return userList
    }

    fun saveUser(file:File , userList : ArrayList<User>) {
        try{
            objectMapper.writeValue(file,userList)
        }catch(exception : Exception){
            println("write to file failed")
            exception.printStackTrace()
        }
    }
}