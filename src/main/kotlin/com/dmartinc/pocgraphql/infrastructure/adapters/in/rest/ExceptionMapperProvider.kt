package com.dmartinc.pocgraphql.infrastructure.adapters.`in`.rest

import com.dmartinc.pocgraphql.core.AuthorNotFound
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper
import javax.ws.rs.ext.Provider

data class ErrorResponse(val message: String?)

inline fun <reified T> T.logger(): Logger {
    return LoggerFactory.getLogger(T::class.java)
}

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
class ItemsNotFoundMapperProvider : ExceptionMapper<AuthorNotFound> {
    override fun toResponse(exception: AuthorNotFound): Response {
        logger().warn("AuthorNotFound: ${exception.message}")
        return Response.status(Response.Status.NOT_FOUND)
            .type(MediaType.APPLICATION_JSON_TYPE)
            .entity(ErrorResponse(exception.message))
            .build()
    }
}
