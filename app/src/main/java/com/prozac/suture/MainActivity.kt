package com.prozac.suture

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.prozac.suture.adapter.ChunkRecyclerViewAdapter
import com.prozac.suture.base.BaseChunk

class MainActivity : AppCompatActivity() {
    /**
     * 主RecyclerView
     */
    private lateinit var recyclerView:RecyclerView
    /**
     * 数据适配器
     */
    private lateinit var adapter:ChunkRecyclerViewAdapter
    /**
     * 布局管理器
     */
    private lateinit var layoutManager:RecyclerView.LayoutManager
    /**
     * 块数组
     */
    private lateinit var chunks:ArrayList<BaseChunk>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
        bindData()
    }

    /**
     * 初始化视图
     */
    private fun initView(){
        recyclerView = findViewById(R.id.main_recyclerView)
    }
    /**
     * 初始化数据
     */
    private fun initData(){
        chunks = ArrayList()
        for(i in 1..2){
            chunks.add(BaseChunk("ChunkDemo","我是Chunk $i"))
        }
    }
    /**
     * 绑定数据
     */
    private fun bindData(){
        adapter = ChunkRecyclerViewAdapter(this,chunks)
        layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager

    }
}
