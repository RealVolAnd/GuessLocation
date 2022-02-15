package com.ssstor.guesslocation.utils

import com.ssstor.guesslocation.USER_UID_LEN

object UtilsMath {
    fun getNewUserId(): String
    {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..USER_UID_LEN)
            .map { allowedChars.random() }
            .joinToString("")
    }
}