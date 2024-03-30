package com.example.rareprobproject.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rareprobproject.Dataclasses.GameItem
import com.example.rareprobproject.R
import com.example.rareprobproject.databinding.CardItemBinding

class GameItemAdapter  (private val context: Context,private val playVisibility:Boolean) :
    RecyclerView.Adapter<GameItemAdapter.ViewHolder>() {

    private var items = emptyList<GameItem>()

    fun setItems(newItems: List<GameItem>) {
        items = newItems
        notifyDataSetChanged()
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = CardItemBinding.bind(itemView)
        init {
            if (playVisibility) {
                binding.playButton.visibility = View.VISIBLE
                binding.namePlay.visibility=View.VISIBLE
                binding.name.visibility=View.GONE
            } else {
                binding.playButton.visibility = View.GONE
                binding.namePlay.visibility=View.GONE
                binding.name.visibility=View.VISIBLE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=items[position]
        holder.binding.image.setImageResource(item.iconResId)

        if(playVisibility)
            holder.binding.namePlay.text=item.heading
        else
            holder.binding.name.text=item.heading

    }


}