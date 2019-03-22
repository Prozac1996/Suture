package com.prozac.suture.retrofit

import android.util.Log

class Translation{

    private val TAG = "Translation"

    private var status:Int = 0

    private lateinit var content:Content

    class Content{
        public lateinit var from:String
        public lateinit var to:String
        public lateinit var vendor:String
        public lateinit var out:String
        public var errNo:Int = 0
    }

    public fun show(){
        Log.d(TAG,"$status")
        Log.d(TAG,content.from+"")
        Log.d(TAG,content.to+"")
        Log.d(TAG,content.vendor+"")
        Log.d(TAG,content.out+"")
        Log.d(TAG,"${content.errNo}")
    }
}