package com.dmartinc.pocgraphql.core.usecases.queries

import com.dmartinc.pocgraphql.core.Book
import com.dmartinc.pocgraphql.core.BookNotFound
import com.dmartinc.pocgraphql.core.ports.BookByIdRetriever

class FindBook(private val bookByIdRetriever: BookByIdRetriever) {

    fun query(bookId: Int): Book =
        bookByIdRetriever.retrieveOne(bookId)
            ?: throw BookNotFound(bookId)
}
