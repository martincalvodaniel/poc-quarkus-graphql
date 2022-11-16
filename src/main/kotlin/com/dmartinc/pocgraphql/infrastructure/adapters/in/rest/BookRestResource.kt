package com.dmartinc.pocgraphql.infrastructure.adapters.`in`.rest

import com.dmartinc.pocgraphql.core.usecases.actions.DeleteBook
import com.dmartinc.pocgraphql.core.usecases.queries.FindBook
import javax.transaction.Transactional
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/books/{id}")
class BookRestResource(
    private val findBook: FindBook,
    private val deleteBook: DeleteBook
) {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun findBook(@PathParam("id") id: String): BookWithoutIdDto = BookWithoutIdDto.fromDomain(findBook.query(id))

    @Transactional
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    fun deleteBook(@PathParam("id") id: String): Response {
        deleteBook.execute(id)
        return Response.status(Response.Status.NO_CONTENT).build()
    }
}
