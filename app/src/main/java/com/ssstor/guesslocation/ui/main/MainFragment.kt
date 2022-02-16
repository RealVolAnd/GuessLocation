package com.ssstor.guesslocation.ui.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import com.ssstor.guesslocation.App
import com.ssstor.guesslocation.R
import com.ssstor.guesslocation.databinding.FragmentMainBinding
import com.ssstor.guesslocation.screens.AndroidScreens
import com.ssstor.guesslocation.utils.BackButtonListener
import com.ssstor.guesslocation.utils.UtilsMessages
import com.ssstor.guesslocation.utils.UtilsSharedPreferences

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

        setListeners()

        return vb.root
    }

    private fun setListeners() {
        vb.mainNameButton.setOnClickListener {
            checkNameAndGoHome()
        }
        vb.mainNameEditText.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                checkNameAndGoHome()
                true
            } else {
                false
            }
        }

       vb.mainNameEditText.addTextChangedListener(object : TextWatcher {
           override fun afterTextChanged(s: Editable?) {
               if(vb.mainNameEditText.text!!.isNotBlank()){
                   vb.mainNameButton.visibility = View.VISIBLE
               } else {
                   vb.mainNameButton.visibility = View.GONE
               }
           }

           override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
           }

           override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
           }
       })
    }

    override fun onStart() {
        super.onStart()
        vb.mainNameEditText.requestFocus()
    }

    override fun onDestroy() {
        _vb = null
        super.onDestroy()
    }

    private fun checkNameAndGoHome(){
        if(vb.mainNameEditText.text!!.isNotBlank()){
           saveName(vb.mainNameEditText.text.toString())
            App.instance.router.navigateTo(AndroidScreens().home())
        } else {
            UtilsMessages.showMessage("Name can not be blank")
        }
    }

    private fun saveName(name:String){
        UtilsSharedPreferences.setUserName(name)
        App.currentUserName = name
    }

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun backPressed(): Boolean {
        return true
    }
}