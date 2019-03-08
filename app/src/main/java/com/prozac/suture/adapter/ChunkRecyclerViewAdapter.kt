package com.prozac.suture.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.prozac.suture.R
import com.prozac.suture.base.BaseChunk
import com.prozac.suture.base.BaseChunkViewHolder

class ChunkRecyclerViewAdapter(context:Context,chunks:ArrayList<BaseChunk>): RecyclerView.Adapter<BaseChunkViewHolder>(){

    private var mContext = context
    private var mChunks = chunks


    override fun getItemCount(): Int {
        if(mChunks != null){
            return mChunks.size
        }
        return 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseChunkViewHolder {
        var view : View = LayoutInflater.from(mContext).inflate(R.layout.chunk_demo,parent,false)
        return BaseChunkViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseChunkViewHolder, position: Int) {
        var chunk : BaseChunk = mChunks.get(position)

    }


}