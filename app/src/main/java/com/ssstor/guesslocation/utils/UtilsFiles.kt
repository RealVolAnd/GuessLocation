package com.ssstor.guesslocation.utils

import android.content.Context
import com.ssstor.guesslocation.App
import com.ssstor.guesslocation.data.entities.GLevel
import java.io.*

object UtilsFiles {

    fun loadLevels() {
        var fis: FileInputStream? = null
        try {
            fis = App.instance.openFileInput("page{${App.currentPage}}");
        } catch (e: FileNotFoundException) {
            e.printStackTrace();
        }
        try {
            val ois = ObjectInputStream(fis);
            App.currentPageLevelsList = (ois.readObject() as ArrayList<GLevel>)
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
    }

    fun saveLevels() {
        var fos: FileOutputStream? = null
        try {
            fos = App.instance.openFileOutput("page{${App.currentPage}}", Context.MODE_PRIVATE)
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
        try {
            val oos = ObjectOutputStream(fos)
            oos.writeObject(App.currentPageLevelsList)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
