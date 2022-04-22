package com.example.filmmvvm.ui.fragments.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideExtension
import com.example.filmmvvm.R
import com.example.filmmvvm.filmsDto.FilmDto
import kotlinx.android.synthetic.main.item_film.view.*

class FilmAdapter(val onClick: (FilmDto) -> Unit) :
    RecyclerView.Adapter<FilmAdapter.FilmViewHolder>() {
    private val items: MutableList<FilmDto> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        return FilmViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_film, parent, false)
        )
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun update(newList: List<FilmDto>) {
        this.items.clear()
        this.items.addAll(newList)
        notifyDataSetChanged()
    }

    inner class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                adapterPosition.takeIf { it != RecyclerView.NO_POSITION }
                    ?.let { onClick(items[adapterPosition]) }
            }
        }

        fun bind(item: FilmDto) {
            Glide.with(itemView.item_image.context)
                .load(item.poster)
                .into(itemView.item_image)

//            itemView.item_name.text = item.name
//            itemView.item_playtime.text = item.playtime
//            itemView.item_release.text = item.release

        }
    }
}


