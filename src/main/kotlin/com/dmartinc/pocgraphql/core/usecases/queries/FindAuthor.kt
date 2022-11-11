package com.dmartinc.pocgraphql.core.usecases.queries

import com.dmartinc.pocgraphql.core.Author
import com.dmartinc.pocgraphql.core.ports.AuthorByIdRetriever
import com.dmartinc.pocgraphql.graphql.AuthorNotFound

class FindAuthor(private val authorByIdRetriever: AuthorByIdRetriever) {

    fun query(authorId: Int): Author =
        authorByIdRetriever.retrieve(authorId)
            ?: throw AuthorNotFound()
}
