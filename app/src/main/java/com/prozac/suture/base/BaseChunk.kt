package com.prozac.suture.base

import android.content.Context

/**
 * 基础块
 */
open abstract class BaseChunk<CHUNK_DATA>(chunkId:String){

    /**
     * Log Tag
     */
    private val tag : String = "BaseChunk"
    /**
     * context
     */
    lateinit var mContext : Context
    /**
     * 块Id
     */
    var mChunkId = chunkId
    /**
     * 块数据
     */
    var mChunkData: CHUNK_DATA? = null

    /**
     * 带chunkData的数据结构，用于通过数据生成块
     */
    constructor(chunkId:String,chunkData:CHUNK_DATA):this(chunkId = chunkId){
        mChunkData = chunkData
    }

    /**
     * 设置Context
     */
    open fun setContext(context : Context){
        mContext = context
    }

    /**
     * 获得块数据
     */
    open fun getChunkData():CHUNK_DATA?{
        return mChunkData
    }

    /**
     * 绑定块数据
     */
    abstract fun bindData(chunkData: CHUNK_DATA)

    /**
     * 创建layout抽象方法
     */
    abstract fun createLayout():Int





}