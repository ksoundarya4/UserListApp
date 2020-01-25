/**
 * User List App
 * @description User data class having name
 * and mobile number.
 * @file User.kt
 * @author ksoundarya4
 * @version 1.0
 * @since 23/01/2020
 */
package com.bridgelabs.userlist.model

import java.io.Serializable

data class User(val name : String, val mobileNumber : String) : Serializable,Model
