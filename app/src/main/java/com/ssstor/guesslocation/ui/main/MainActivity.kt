package com.ssstor.guesslocation.ui.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.ssstor.guesslocation.App
import com.ssstor.guesslocation.R
import com.ssstor.guesslocation.databinding.ActivityMainBinding
import com.ssstor.guesslocation.screens.AndroidScreens
import com.ssstor.guesslocation.screens.CustomNavigator
import com.ssstor.guesslocation.utils.BackButtonListener

class MainActivity : AppCompatActivity(),MainContract.View {
    private lateinit var vb: ActivityMainBinding
    private lateinit var presenter: MainPresenter
    private val navigator = CustomNavigator(this, R.id.fragment_container)

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && it.backPressed()) {
                return
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb.root)
        presenter = MainPresenter(this)

        if(App.currentUserName.isEmpty()){
            App.instance.router.navigateTo(AndroidScreens().main())
        } else {
            App.instance.router.navigateTo(AndroidScreens().home())
        }

    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigatorHolder.removeNavigator()
    }

    override fun showBusyFile() {
        vb.busyLayout.visibility = View.VISIBLE
    }

    override fun showBusyNetwork() {
        vb.busyLayout.visibility = View.VISIBLE
    }

    override fun goOffline() {
        vb.busyLayout.visibility = View.GONE
    }

    override fun goOnLine() {
        vb.busyLayout.visibility = View.GONE
    }
}