package org.shm.loginactivitywithlistview.entity

import java.io.Serializable

data class UserInfo (var username : String = " ", var password : String = " ") : Serializable {
    override fun toString(): String = username
}