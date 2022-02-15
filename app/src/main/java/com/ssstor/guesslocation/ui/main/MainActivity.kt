package com.ssstor.guesslocation.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ssstor.guesslocation.databinding.ActivityMainBinding
import com.ssstor.guesslocation.utils.BackButtonListener

class MainActivity : AppCompatActivity(),MainContract.View {
    private lateinit var vb: ActivityMainBinding
    private lateinit var presenter: MainPresenter

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
    }
}