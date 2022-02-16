package com.ssstor.guesslocation.ui.home

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.ssstor.guesslocation.App
import com.ssstor.guesslocation.R

class HomeRvAdapter(private val listener:OnClickLevelListener): RecyclerView.Adapter<HomeRvAdapter.ViewHolder>() {

    var dataList = arrayListOf("1","2","3","4","5","6","7","8","9","10")



    // Provide a direct reference to each of the views with data items

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var text: TextView = itemView.findViewById(R.id.level_item_text)
        var root: ConstraintLayout = itemView.findViewById(R.id.level_item_root)
    }

    // Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRvAdapter.ViewHolder {

        // Inflate the custom layout
        var view = LayoutInflater.from(parent.context).inflate(R.layout.level_item, parent, false)
        return ViewHolder(view)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(holder: HomeRvAdapter.ViewHolder, position: Int) {

        // Get the data model based on position
        var data = dataList[position]
        if(position== App.currentLevelId-1){
            holder.root.background.setTint(App.instance.getColor(R.color.available_level))
        } else if (position<App.currentLevelId-1) {
            holder.root.background.setTint(App.instance.getColor(R.color.finished_level))
        } else {
            holder.root.background.setTint(Color.BLACK)
        }

        holder.root.setOnClickListener {
            listener.onLevelClick(position+1)
        }

        // Set item views based on your views and data model
        holder.text.setText(data)
    }

    //  total count of items in the list
    override fun getItemCount() = dataList.size
}