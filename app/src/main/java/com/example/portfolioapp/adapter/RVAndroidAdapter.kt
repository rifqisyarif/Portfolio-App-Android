package com.example.portfolioapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.portfolioapp.R
import com.example.portfolioapp.data.Portfolio
import com.example.portfolioapp.databinding.ItemAndroidBinding

class RVAndroidAdapter: RecyclerView.Adapter<RVAndroidAdapter.AndroidViewHolder>() {

    private val listData = ArrayList<Portfolio>()
    var onItemClicked: ((Portfolio) -> Unit)? = null

    fun setData(newList: List<Portfolio>?){
        if (newList == null) return
        listData.clear()
        listData.addAll(newList)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AndroidViewHolder =
        AndroidViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.item_android,parent, false)
        )

    override fun onBindViewHolder(holder: AndroidViewHolder, position: Int) {
        val listData = listData[position]
        holder.bind(listData)
    }

    override fun getItemCount(): Int {
        return listData.size
    }
    inner class AndroidViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val binding = ItemAndroidBinding.bind(itemView)

        fun bind(data: Portfolio){
            binding.android = data
            binding.executePendingBindings()
        }

        init {
            binding.root.setOnClickListener{
                onItemClicked?.invoke(listData[adapterPosition])
            }
        }

    }
}

