package com.dmartinc.pocgraphql.infrastructure.adapters.out.mongo

import com.dmartinc.pocgraphql.core.Author
import com.dmartinc.pocgraphql.core.Utils.NOT_YET_IMPLEMENTED
import com.dmartinc.pocgraphql.core.ports.AuthorRetriever
import com.dmartinc.pocgraphql.core.ports.AuthorRemover
import com.dmartinc.pocgraphql.core.ports.AuthorsRetriever
import com.dmartinc.pocgraphql.core.ports.AuthorsStore

class MongoAuthorsRepository :
    AuthorRemover,
    AuthorsRetriever,
    AuthorRetriever,
    AuthorsStore {

    override fun remove(id: Int): Boolean {
        TODO(NOT_YET_IMPLEMENTED)
    }

    override fun retrieve(): List<Author> {
        TODO(NOT_YET_IMPLEMENTED)
    }

    override fun retrieve(id: Int): Author? {
        TODO(NOT_YET_IMPLEMENTED)
    }

    override fun store(author: Author) {
        TODO(NOT_YET_IMPLEMENTED)
    }
}
