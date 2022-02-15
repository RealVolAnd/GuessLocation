package com.ssstor.guesslocation

import android.app.Application
import android.content.Context

class App: Application() {
    companion object {
        lateinit var instance: App

    }
}
val Context.app: App
    get() = applicationContext as App