package com.dmartinc.pocgraphql.core.usecases.queries

import com.dmartinc.pocgraphql.core.Author
import com.dmartinc.pocgraphql.core.ports.AuthorsRetriever

class FindAuthors(private val authorsRetriever: AuthorsRetriever) {

    fun query(): List<Author> = authorsRetriever.retrieve()
}
