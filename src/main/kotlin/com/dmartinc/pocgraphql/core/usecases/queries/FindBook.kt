package com.dmartinc.pocgraphql.core.usecases.queries

import com.dmartinc.pocgraphql.core.Book
import com.dmartinc.pocgraphql.core.BookNotFound
import com.dmartinc.pocgraphql.core.ports.BookRetriever

class FindBook(private val bookRetriever: BookRetriever) {

    fun query(bookId: String): Book =
        bookRetriever.retrieveOne(bookId)
            ?: throw BookNotFound(bookId)
}
