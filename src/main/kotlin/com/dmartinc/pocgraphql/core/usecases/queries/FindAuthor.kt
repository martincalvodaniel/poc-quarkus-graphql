package com.dmartinc.pocgraphql.core.usecases.queries

import com.dmartinc.pocgraphql.core.Author
import com.dmartinc.pocgraphql.core.AuthorNotFound
import com.dmartinc.pocgraphql.core.ports.AuthorRetriever

class FindAuthor(private val authorRetriever: AuthorRetriever) {

    fun query(authorId: Int): Author =
        authorRetriever.retrieve(authorId)
            ?: throw AuthorNotFound(authorId)
}
