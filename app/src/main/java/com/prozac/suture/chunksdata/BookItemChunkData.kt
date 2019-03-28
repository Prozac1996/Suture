package com.prozac.suture.chunksdata

import com.prozac.suture.base.BaseChunkData

/**
 * 书籍单元-块数据
 */
open class BookItemChunkData : BaseChunkData() {

    /**
     * 书籍名称
     */
    open lateinit var bookTitle:String
    /**
     * 书籍图片
     */
    open lateinit var bookImage:String
}