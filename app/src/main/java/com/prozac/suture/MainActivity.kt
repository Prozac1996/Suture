package com.prozac.suture

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import com.prozac.suture.adapter.ChunkRecyclerViewAdapter
import com.prozac.suture.base.BaseChunk
import com.prozac.suture.divider.LineDividerItemDecoration
import com.prozac.suture.retrofit.GetRequest_Interface
import com.prozac.suture.retrofit.Translation
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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
     * 分割线
     */
    private lateinit var lineDecoration:LineDividerItemDecoration
    /**
     * 块数组
     */
    private lateinit var chunks:ArrayList<BaseChunk>

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        SystemClock.sleep(2000)
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
        for(i in 1..99){
            chunks.add(BaseChunk("MyChunk","我是Chunk $i"))
        }
    }
    /**
     * 绑定数据
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private fun bindData(){
        adapter = ChunkRecyclerViewAdapter(this,chunks)
        layoutManager = StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL);
        lineDecoration = LineDividerItemDecoration(this,LineDividerItemDecoration.ALL)
//        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
//            var myDrawable: Drawable? = this.getDrawable(R.drawable.no_more_tip)
//            lineDecoration.setDivider(myDrawable);
//        }
        recyclerView.addItemDecoration(lineDecoration)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager

    }
}
