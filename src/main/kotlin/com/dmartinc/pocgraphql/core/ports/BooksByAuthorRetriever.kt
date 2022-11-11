package com.dmartinc.pocgraphql.core.ports

import com.dmartinc.pocgraphql.core.Author
import com.dmartinc.pocgraphql.core.Book

interface BooksByAuthorRetriever {
    fun retrieve(author: Author): List<Book>
}
