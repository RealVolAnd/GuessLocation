package com.ssstor.guesslocation.screens

import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun main(): Screen
    fun home(): Screen
    fun playground(): Screen
}