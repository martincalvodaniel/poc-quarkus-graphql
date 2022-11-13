package com.dmartinc.pocgraphql.core.usecases.queries

import com.dmartinc.pocgraphql.core.Book
import com.dmartinc.pocgraphql.core.ports.BooksRetriever

class FindBooks(private val booksRetriever: BooksRetriever) {

    fun query(authorId: Int? = null): List<Book> = booksRetriever.retrieve(authorId)
}
