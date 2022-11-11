package com.dmartinc.pocgraphql.core.usecases.actions

import com.dmartinc.pocgraphql.core.Book
import com.dmartinc.pocgraphql.core.ports.BooksStore

class CreateBook(private val booksStore: BooksStore) {

    fun execute(book: Book) {
        booksStore.store(book)
    }
}
