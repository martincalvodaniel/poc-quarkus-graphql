package com.dmartinc.pocgraphql.core.ports

import com.dmartinc.pocgraphql.core.Book

interface BooksRetriever {
    fun retrieve(id: Int): Book?
    fun retrieve(): List<Book>
}
