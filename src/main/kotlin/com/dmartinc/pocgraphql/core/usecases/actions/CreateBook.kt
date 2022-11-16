package com.dmartinc.pocgraphql.core.usecases.actions

import com.dmartinc.pocgraphql.core.BookToCreate
import com.dmartinc.pocgraphql.core.ports.BooksStore

class CreateBook(private val booksStore: BooksStore) {

    fun execute(bookToCreate: BookToCreate) {
        booksStore.store(bookToCreate)
    }
}
