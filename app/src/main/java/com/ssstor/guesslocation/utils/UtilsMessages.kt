package com.ssstor.guesslocation.utils

import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.ssstor.guesslocation.App

object UtilsMessages {
    fun showMessage(text:String){
        Toast.makeText(App.instance,text,LENGTH_SHORT).show()
    }

}