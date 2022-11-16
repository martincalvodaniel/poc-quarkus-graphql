package com.dmartinc.pocgraphql.infrastructure.adapters.out.mongo

import com.dmartinc.pocgraphql.core.Book
import com.dmartinc.pocgraphql.core.Utils.NOT_YET_IMPLEMENTED
import com.dmartinc.pocgraphql.core.ports.BookRemover
import com.dmartinc.pocgraphql.core.ports.BookRetriever
import com.dmartinc.pocgraphql.core.ports.BooksRetriever
import com.dmartinc.pocgraphql.core.ports.BooksStore

class MongoBooksRepository :
    BookRemover,
    BookRetriever,
    BooksRetriever,
    BooksStore {

    override fun remove(id: String): Boolean {
        TODO(NOT_YET_IMPLEMENTED)
    }

    override fun retrieveOne(id: String): Book? {
        TODO(NOT_YET_IMPLEMENTED)
    }

    override fun retrieve(authorId: String?): List<Book> {
        TODO(NOT_YET_IMPLEMENTED)
    }

    override fun store(book: Book) {
        TODO(NOT_YET_IMPLEMENTED)
    }
}
