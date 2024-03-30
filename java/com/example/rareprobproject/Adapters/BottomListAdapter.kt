package com.example.rareprobproject.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rareprobproject.Dataclasses.GameItem
import com.example.rareprobproject.R
import com.example.rareprobproject.databinding.BottomRvItemBinding
import com.example.rareprobproject.databinding.CardItemBinding


class BottomListAdapter  (private val context: Context) :
    RecyclerView.Adapter<BottomListAdapter.ViewHolder>() {

    private var items = emptyList<String>()

    fun setBottomItems(newItems: List<String>) {
        items = newItems
        notifyDataSetChanged()
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = BottomRvItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.bottom_rv_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=items[position]
        holder.binding.text.text=item

    }


}