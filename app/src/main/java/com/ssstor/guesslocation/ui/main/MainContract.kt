package com.ssstor.guesslocation.ui.main

class MainContract {
    interface View{
        fun showBusyFile()
        fun showBusyNetwork()
        fun goOffline()
        fun goOnLine()

    }
    interface Presenter {
    }
}