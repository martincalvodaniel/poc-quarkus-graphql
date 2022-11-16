package com.dmartinc.pocgraphql.core.usecases.actions

import com.dmartinc.pocgraphql.core.BookNotFound
import com.dmartinc.pocgraphql.core.ports.BookRemover

class DeleteBook(private val bookRemover: BookRemover) {

    fun execute(bookId: String) {
        if (bookRemover.remove(bookId).not()) {
            throw BookNotFound(bookId)
        }
    }
}
