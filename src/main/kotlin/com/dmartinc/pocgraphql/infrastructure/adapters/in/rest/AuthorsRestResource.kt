package com.dmartinc.pocgraphql.infrastructure.adapters.`in`.rest

import com.dmartinc.pocgraphql.core.usecases.actions.CreateAuthor
import com.dmartinc.pocgraphql.core.usecases.queries.FindAuthors
import javax.transaction.Transactional
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/authors")
class AuthorsRestResource(
    private val createAuthor: CreateAuthor,
    private val findAuthors: FindAuthors
) {

    @Transactional
    @POST
    fun createAuthor(author: AuthorDto): Response {
        createAuthor.execute(author.toDomain())
        return Response.status(201).build()
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun findAuthors(): AuthorsDto = AuthorsDto.fromDomain(findAuthors.query())
}
