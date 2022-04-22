package com.example.filmmvvm.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.filmmvvm.R
import com.example.filmmvvm.filmsDto.FilmDto
import kotlinx.android.synthetic.main.fragment_film_details.*

private const val ARG_PARAM = "param1"

class FilmDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_film_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val filmDto:FilmDto = arguments?.getSerializable(ARG_PARAM) as FilmDto
        Glide.with(details_image.context).load(filmDto.poster).into(details_image)
        details_name.text = filmDto.name
        details_description.text = filmDto.description
        details_playtime.text = filmDto.playtime
        details_release.text = filmDto.release

        setToolbar()
    }

    private fun setToolbar(){
       toolbar_details?.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }


    companion object {

        @JvmStatic
        fun newInstance(filmDto: FilmDto) =
            FilmDetailsFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM, filmDto)

                }
            }
    }
    }


