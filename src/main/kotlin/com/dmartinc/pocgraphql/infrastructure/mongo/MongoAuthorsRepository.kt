package com.dmartinc.pocgraphql.infrastructure.mongo

import com.dmartinc.pocgraphql.core.Author
import com.dmartinc.pocgraphql.core.ports.AuthorByIdRetriever
import com.dmartinc.pocgraphql.core.ports.AuthorsRetriever
import com.dmartinc.pocgraphql.core.ports.AuthorsStore

private const val NOT_YET_IMPLEMENTED = "Not yet implemented"

class MongoAuthorsRepository :
    AuthorsRetriever,
    AuthorByIdRetriever,
    AuthorsStore {

    override fun retrieve(id: Int): Author? {
        TODO(NOT_YET_IMPLEMENTED)
    }

    override fun retrieve(): List<Author> {
        TODO(NOT_YET_IMPLEMENTED)
    }

    override fun store(author: Author) {
        TODO(NOT_YET_IMPLEMENTED)
    }
}
