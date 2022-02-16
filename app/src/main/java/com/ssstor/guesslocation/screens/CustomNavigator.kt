package com.ssstor.guesslocation.screens

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.ssstor.guesslocation.R
import com.ssstor.guesslocation.ui.main.MainActivity

class CustomNavigator(
    activity: MainActivity,
    containerID: Int
) : AppNavigator(activity, containerID) {
    val stackCount: Int
        get() = try {
            localStackCopy.size + 1
        } catch (e: Exception) {
            fragmentManager.backStackEntryCount + 1
        }

    override fun setupFragmentTransaction(
        screen: FragmentScreen,
        fragmentTransaction: FragmentTransaction,
        currentFragment: Fragment?,
        nextFragment: Fragment
    ) {
        super.setupFragmentTransaction(
            screen,
            fragmentTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out),
            currentFragment,
            nextFragment
        )
    }


    override fun applyCommands(commands: Array<out Command>) {
        super.applyCommands(commands)

    }

}