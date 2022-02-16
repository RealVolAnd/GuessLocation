package com.ssstor.guesslocation.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.ssstor.guesslocation.App
import com.ssstor.guesslocation.databinding.FragmentHomeBinding
import com.ssstor.guesslocation.screens.AndroidScreens

class HomeFragment : Fragment(),OnClickLevelListener {
    private var _vb: FragmentHomeBinding? = null
    private val vb get() = _vb!!
    private lateinit var  adapter: HomeRvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _vb = FragmentHomeBinding.inflate(inflater, container, false)
        vb.levelsRv?.layoutManager = GridLayoutManager(requireContext(),5)
        adapter = HomeRvAdapter(this)
        vb.levelsRv?.adapter = adapter
        return vb.root
    }

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onLevelClick(levelId: Int) {
        App.instance.router.navigateTo(AndroidScreens().playground())
    }
}