package com.dmartinc.pocgraphql.core.ports

import com.dmartinc.pocgraphql.core.BookToCreate

interface BooksStore {
    fun store(bookToCreate: BookToCreate)
}
