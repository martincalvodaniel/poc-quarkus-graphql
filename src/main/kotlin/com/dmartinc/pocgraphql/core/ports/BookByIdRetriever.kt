package com.dmartinc.pocgraphql.core.ports

import com.dmartinc.pocgraphql.core.Book

interface BookByIdRetriever {
    fun retrieve(bookId: Int): Book?
}
