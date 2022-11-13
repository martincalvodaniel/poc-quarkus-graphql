package com.dmartinc.pocgraphql.infrastructure.adapters.`in`.rest

import com.dmartinc.pocgraphql.core.usecases.actions.CreateBook
import com.dmartinc.pocgraphql.core.usecases.queries.FindBook
import com.dmartinc.pocgraphql.core.usecases.queries.FindBooks
import javax.transaction.Transactional
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/books")
class BooksRestResource(
    private val createBook: CreateBook,
    private val findBook: FindBook,
    private val findBooks: FindBooks
) {

    @Transactional
    @POST
    fun createBook(bookDto: BookDto): Response {
        createBook.execute(bookDto.toDomain())
        return Response.status(201).build()
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun findBook(@PathParam("id") id: Int): BookWithoutIdDto = BookWithoutIdDto.fromDomain(findBook.query(id))

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun findBooks(): BooksDto = BooksDto.fromDomain(findBooks.query())
}
