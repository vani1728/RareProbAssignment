package com.example.rareprobproject.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rareprobproject.Dataclasses.BannerData
import com.example.rareprobproject.R
import com.example.rareprobproject.databinding.BannerItemBinding

class BannerAdapter(private  val items: List<BannerData>,) :
    RecyclerView.Adapter<BannerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = BannerItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.banner_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=items[position]
        holder.binding.bannerHeaderText.text=item.heading
        holder.binding.bannerSubHeaderText.text=item.subheading
        holder.binding.bannerImage.setImageResource(item.iconResId)

    }


}