package com.ssstor.guesslocation.screens

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.ssstor.guesslocation.ui.home.HomeFragment
import com.ssstor.guesslocation.ui.main.MainFragment
import com.ssstor.guesslocation.ui.playground.PlaygroundFragment

class AndroidScreens : IScreens {
    override fun main() = FragmentScreen { MainFragment.newInstance() }
    override fun home() = FragmentScreen { HomeFragment.newInstance() }
    override fun playground() = FragmentScreen{ PlaygroundFragment.newInstance() }
}