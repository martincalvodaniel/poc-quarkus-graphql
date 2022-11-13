package com.dmartinc.pocgraphql.infrastructure.adapters.`in`.rest

import com.dmartinc.pocgraphql.core.usecases.actions.CreateAuthor
import com.dmartinc.pocgraphql.core.usecases.queries.FindAuthorAndBooks
import com.dmartinc.pocgraphql.core.usecases.queries.FindAuthorsAndBooks
import javax.transaction.Transactional
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/authors")
class AuthorsRestResource(
    private val createAuthor: CreateAuthor,
    private val findAuthorAndBooks: FindAuthorAndBooks,
    private val findAuthorsAndBooks: FindAuthorsAndBooks
) {

    @Transactional
    @POST
    fun createAuthor(author: AuthorDto): Response {
        createAuthor.execute(author.toDomain())
        return Response.status(201).build()
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun findAuthor(@PathParam("id") id: Int): AuthorDto {
        val authorAndBooks = findAuthorAndBooks.query(id)
        return AuthorDto.fromDomain(authorAndBooks)
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun findAuthors(): AuthorsDto {
        val authorsAndBooks = findAuthorsAndBooks.query()
        return AuthorsDto.fromDomain(authorsAndBooks)
    }
}
