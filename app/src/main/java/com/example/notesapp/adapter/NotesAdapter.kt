package com.example.notesapp.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.Entities.Notes
import com.example.notesapp.R
import com.example.notesapp.databinding.ItemRvNotesBinding

class NotesAdapter(var arrList: List<Notes>) : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val binding = ItemRvNotesBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return NotesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return arrList.size
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        with(holder) {
            binding.tvTitle.text = arrList[position].title
            binding.tvDesc.text = arrList[position].noteText
            binding.tvDateTime.text = arrList[position].dateTime

            if (arrList[position].color != null) {
                binding.cardView.setCardBackgroundColor(Color.parseColor(arrList[position].color))
            } else {
                val colorLightBlack = ContextCompat.getColor(binding.root.context, R.color.ColorLightBlack)
                binding.cardView.setCardBackgroundColor(colorLightBlack)
            }
        }
    }

    class NotesViewHolder(val binding: ItemRvNotesBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}