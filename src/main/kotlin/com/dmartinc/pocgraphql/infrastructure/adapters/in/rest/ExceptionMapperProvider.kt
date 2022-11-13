package com.dmartinc.pocgraphql.infrastructure.adapters.`in`.rest

import com.dmartinc.pocgraphql.core.AuthorNotFound
import com.dmartinc.pocgraphql.core.BookNotFound
import com.dmartinc.pocgraphql.core.Utils.logger
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper
import javax.ws.rs.ext.Provider

data class ErrorResponse(val message: String?)

@Provider
class ExceptionMapperProvider : ExceptionMapper<Throwable> {
    override fun toResponse(exception: Throwable): Response {
        logger().error("Exception: ${exception.message}", exception)
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            .type(MediaType.APPLICATION_JSON_TYPE)
            .entity(ErrorResponse("Something went wrong"))
            .build()
    }
}

@Provider
class IllegalArgumentMapperProvider : ExceptionMapper<IllegalArgumentException> {
    override fun toResponse(exception: IllegalArgumentException): Response {
        logger().error("IllegalArgumentException: ${exception.message}", exception)
        return Response.status(Response.Status.BAD_REQUEST)
            .type(MediaType.APPLICATION_JSON_TYPE)
            .entity(ErrorResponse(exception.message))
            .build()
    }
}

@Provider
class AuthorNotFoundMapperProvider : ExceptionMapper<AuthorNotFound> {
    override fun toResponse(exception: AuthorNotFound): Response {
        logger().warn("AuthorNotFound: ${exception.message}")
        return Response.status(Response.Status.NOT_FOUND)
            .type(MediaType.APPLICATION_JSON_TYPE)
            .entity(ErrorResponse(exception.message))
            .build()
    }
}

@Provider
class BookNotFoundMapperProvider : ExceptionMapper<BookNotFound> {
    override fun toResponse(exception: BookNotFound): Response {
        logger().warn("AuthorNotFound: ${exception.message}")
        return Response.status(Response.Status.NOT_FOUND)
            .type(MediaType.APPLICATION_JSON_TYPE)
            .entity(ErrorResponse(exception.message))
            .build()
    }
}
