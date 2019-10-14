package org.shm.a016_startactivityforresult

import java.io.Serializable

data class UserInfo (var fullname: String, val username: String, val email: String, val isFemale: Boolean) :
    Serializable