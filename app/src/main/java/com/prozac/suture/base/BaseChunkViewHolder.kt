package com.prozac.suture.base

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.prozac.suture.R

class BaseChunkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var chunk_title : TextView = itemView.findViewById(R.id.chunk_title)
    var rootView : View = itemView.findViewById(R.id.rootView)

}