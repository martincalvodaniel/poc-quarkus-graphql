package com.dmartinc.pocgraphql.infrastructure.adapters.`in`.rest

import com.dmartinc.pocgraphql.core.usecases.actions.CreateBook
import com.dmartinc.pocgraphql.core.usecases.queries.FindBooks
import javax.transaction.Transactional
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/authors/{authorId}/books")
class AuthorBooksRestResource(
    private val createBook: CreateBook,
    private val findBooks: FindBooks
) {

    @Transactional
    @POST
    fun createBook(@PathParam("authorId") authorId: String, book: BookWithoutIdNorAuthor): Response {
        createBook.execute(book.toDomain(authorId))
        return Response.status(201).build()
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun findBooksByAuthorId(@PathParam("authorId") authorId: String): BooksByAuthorIdDto =
        BooksByAuthorIdDto.fromDomain(findBooks.query(authorId))
}
