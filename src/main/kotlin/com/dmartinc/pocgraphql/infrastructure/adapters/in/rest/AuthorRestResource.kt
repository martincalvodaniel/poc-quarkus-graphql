package com.dmartinc.pocgraphql.infrastructure.adapters.`in`.rest

import com.dmartinc.pocgraphql.core.usecases.actions.DeleteAuthor
import com.dmartinc.pocgraphql.core.usecases.queries.FindAuthor
import javax.transaction.Transactional
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/authors/{id}")
class AuthorRestResource(
    private val findAuthor: FindAuthor,
    private val deleteAuthor: DeleteAuthor
) {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun findAuthor(@PathParam("id") id: Int): AuthorWithoutIdDto = AuthorWithoutIdDto.fromDomain(findAuthor.query(id))

    @Transactional
    @DELETE
    fun deleteAuthor(@PathParam("id") id: Int): Response {
        deleteAuthor.execute(id)
        return Response.noContent().build()
    }
}
