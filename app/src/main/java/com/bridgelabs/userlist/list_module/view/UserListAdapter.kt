package com.bridgelabs.userlist.list_module.view

import android.R
import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bridgelabs.userlist.list_module.model.User
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier


class UserListAdapter(val context: Activity, private val users: List<User>) :
    ArrayAdapter<User>(context, com.bridgelabs.userlist.R.layout.activity_listview, users) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(com.bridgelabs.userlist.R.layout.activity_listview, null, true)

        val titleText = rowView.findViewById(com.bridgelabs.userlist.R.id.user_name) as TextView
        val subtitleText = rowView.findViewById(com.bridgelabs.userlist.R.id.phone_number) as TextView

        titleText.text = users[position].name
        subtitleText.text = users[position].mobileNumber

        return rowView
    }

}