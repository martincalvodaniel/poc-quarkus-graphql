package com.dmartinc.pocgraphql.core.usecases.queries

import com.dmartinc.pocgraphql.core.Author
import com.dmartinc.pocgraphql.core.Book
import com.dmartinc.pocgraphql.core.ports.BooksByAuthorRetriever

class FindBooksByAuthor(private val booksByAuthorRetriever: BooksByAuthorRetriever) {

    fun query(author: Author): List<Book> = booksByAuthorRetriever.retrieve(author)
}
