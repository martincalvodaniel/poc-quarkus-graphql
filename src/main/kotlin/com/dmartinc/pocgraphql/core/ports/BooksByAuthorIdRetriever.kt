package com.dmartinc.pocgraphql.core.ports

import com.dmartinc.pocgraphql.core.Book

interface BooksByAuthorIdRetriever {
    fun retrieveByAuthorId(authorId: Int): List<Book>
}
