package com.example.filmmvvm.ui

import android.os.Bundle
import com.example.filmmvvm.R
import com.example.filmmvvm.base.BaseActivity
import com.example.filmmvvm.ui.fragments.FilmDtoFragment

class MainActivity : BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container,FilmDtoFragment())
            .commit()
    }
}