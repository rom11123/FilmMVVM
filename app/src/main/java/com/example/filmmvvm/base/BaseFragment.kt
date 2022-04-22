package com.example.filmmvvm.base

import androidx.fragment.app.Fragment
import com.example.filmmvvm.R

const val BACK_STACK = "backStack"
abstract class BaseFragment:Fragment() {
    fun addFragment(fragment:Fragment){
        parentFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container,fragment)
            .addToBackStack(BACK_STACK)
            .commit()
    }

}