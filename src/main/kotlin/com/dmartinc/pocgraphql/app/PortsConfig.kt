package com.dmartinc.pocgraphql.app

import com.dmartinc.pocgraphql.core.ports.AuthorsRetriever
import com.dmartinc.pocgraphql.core.ports.BooksRetriever
import com.dmartinc.pocgraphql.infrastructure.PanacheAuthorsRetriever
import com.dmartinc.pocgraphql.infrastructure.PanacheBooksRetriever
import io.quarkus.arc.DefaultBean
import javax.enterprise.context.Dependent
import javax.enterprise.inject.Produces

@Dependent
class PortsConfig {

    @Produces
    @DefaultBean
    fun authorsRetriever(): AuthorsRetriever = PanacheAuthorsRetriever()

    @Produces
    @DefaultBean
    fun booksRetriever(): BooksRetriever = PanacheBooksRetriever()
}
