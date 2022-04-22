package com.example.filmmvvm.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.filmmvvm.R
import com.example.filmmvvm.base.BaseFragment
import com.example.filmmvvm.repositories.FragmentViewModel
import com.example.filmmvvm.ui.fragments.adapters.FilmAdapter
import kotlinx.android.synthetic.main.fragment_film_dto.*

class FilmDtoFragment : BaseFragment() {
    lateinit var fragmentViewModel:FragmentViewModel
    private val filmAdapter = FilmAdapter{
        addFragment(FilmDetailsFragment.newInstance(it))

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentViewModel = ViewModelProvider(this).get(FragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View?
        // Inflate the layout for this fragment
       = inflater.inflate(R.layout.fragment_film_dto, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.apply { adapter = filmAdapter }
        fragmentViewModel.getFilm()
        fragmentViewModel.liveData.observe(viewLifecycleOwner, Observer {
            it.let { filmAdapter.update(it) }
        })

    }

}