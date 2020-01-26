/**
 * UserListAPP
 * @purpose Class to perform
 */
package com.bridgelabs.userlist.Presenter

import android.widget.EditText
import com.bridgelabs.userlist.R
import com.bridgelabs.userlist.model.FileSystem
import com.bridgelabs.userlist.model.User
import com.bridgelabs.userlist.view.AddActivity


class AddUser : Presenter {

    private val view = AddActivity()
    private val model = FileSystem()

    fun addUserToList(): ArrayList<User> {

        val editUserName = view.findViewById<EditText>(R.id.add_user_name)
        val userName = editUserName.text.toString()

        val editUserNumber = view.findViewById<EditText>(R.id.add_user_mobile_number)
        val userNumber = editUserNumber.text.toString()

        val user = User(userName, userNumber)

        val userList: ArrayList<User> = model.readUser(view.assets.open("user.json"))
        userList.add(user)
        return userList
    }
}