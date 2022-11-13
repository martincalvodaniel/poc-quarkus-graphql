package com.dmartinc.pocgraphql.core.usecases.queries

import com.dmartinc.pocgraphql.core.Book
import com.dmartinc.pocgraphql.core.ports.BooksByAuthorIdRetriever

class FindBooksByAuthorId(private val booksByAuthorIdRetriever: BooksByAuthorIdRetriever) {

    fun query(authorId: Int): List<Book> = booksByAuthorIdRetriever.retrieve(authorId)
}
