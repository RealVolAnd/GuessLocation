package com.ssstor.guesslocation.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ssstor.guesslocation.R
import com.ssstor.guesslocation.databinding.FragmentMainBinding
import com.ssstor.guesslocation.utils.BackButtonListener

class MainFragment : Fragment(), BackButtonListener {
    private var _vb: FragmentMainBinding? = null
    private val vb get() = _vb!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _vb = FragmentMainBinding.inflate(inflater, container, false)

        return vb.root
    }

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun backPressed(): Boolean {
        return true
    }
}