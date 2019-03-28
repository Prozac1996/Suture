package com.prozac.suture.base

/**
 * 基础块数据
 */
open class BaseChunkData {

    lateinit var mChunkId:String

    open fun setChunkId(chunkId:String){
        mChunkId = chunkId
    }

    open fun getChunkId():String{
        return mChunkId
    }
}