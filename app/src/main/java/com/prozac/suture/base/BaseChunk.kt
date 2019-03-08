package com.prozac.suture.base

import android.util.Log

/**
 * 一块
 */
class BaseChunk(chunkId:String,chunkName:String){

    val TAG : String = "BaseChunk"
    val mChunkId = chunkId
    val mChunkName = chunkName

    /**
     * 初始化块
     */
    init{
        Log.d(TAG,"chunkId : $chunkId")
    }



}