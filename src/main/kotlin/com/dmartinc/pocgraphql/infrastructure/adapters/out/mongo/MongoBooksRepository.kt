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

    override fun remove(id: Int): Boolean {
        TODO(NOT_YET_IMPLEMENTED)
    }

    override fun retrieveOne(id: Int): Book? {
        TODO(NOT_YET_IMPLEMENTED)
    }

    override fun retrieve(authorId: Int?): List<Book> {
        TODO(NOT_YET_IMPLEMENTED)
    }

    override fun store(book: Book) {
        TODO(NOT_YET_IMPLEMENTED)
    }
}
