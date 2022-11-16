package com.dmartinc.pocgraphql.core.ports

import com.dmartinc.pocgraphql.core.Book

interface BooksRetriever {
    fun retrieve(authorId: String? = null): List<Book>
}
