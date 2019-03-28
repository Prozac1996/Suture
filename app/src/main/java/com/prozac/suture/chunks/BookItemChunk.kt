package com.prozac.suture.chunks

import com.prozac.suture.R
import com.prozac.suture.base.BaseChunk
import com.prozac.suture.chunksdata.BookItemChunkData

/**
 * 书籍单元
 */
class BookItemChunk(chunkId: String) : BaseChunk<BookItemChunkData>(chunkId) {

    /**
     * 创建布局
     */
    override fun createLayout(): Int {
        return R.layout.chunk_book_item
    }

    /**
     * 绑定数据
     */
    override fun bindData(chunkData: BookItemChunkData) {

    }


}