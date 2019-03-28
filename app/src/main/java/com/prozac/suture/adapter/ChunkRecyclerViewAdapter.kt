package com.prozac.suture.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.prozac.suture.R
import com.prozac.suture.base.BaseChunk
import com.prozac.suture.base.BaseChunkData
import com.prozac.suture.base.BaseChunkViewHolder

/**
 * 块显示适配器
 */
class ChunkRecyclerViewAdapter(context: Context, chunks: ArrayList<BaseChunk<BaseChunkData>>) :
    RecyclerView.Adapter<BaseChunkViewHolder>() {

    private var mContext = context
    private var mChunks = chunks
    private var mHeights : ArrayList<Int> = ArrayList<Int>()

    init{
        for (i in 0..mChunks.size){
            mHeights.add((100+Math.random() * 300).toInt())
        }
    }

    /**
     * 获取当前Chunk数量
     */
    override fun getItemCount(): Int {
        if (mChunks != null) {
            return mChunks.size
        }
        return 0
    }

    /**
     * 创建视图
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseChunkViewHolder {
        var view: View = LayoutInflater.from(mContext).inflate(R.layout.chunk_demo, parent, false)
        return BaseChunkViewHolder(view)
    }

    /**
     * 绑定视图
     */
    override fun onBindViewHolder(holder: BaseChunkViewHolder, position: Int) {
        var chunk: BaseChunk<BaseChunkData> = mChunks.get(position)
            var lp: ViewGroup.LayoutParams = holder.chunk_title.layoutParams
        lp.height = mHeights.get(position)
        holder.chunk_title.layoutParams = lp
    }
}