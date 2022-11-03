package com.dmartinc.pocgraphql.graphql

import io.smallrye.graphql.api.ErrorCode

@ErrorCode("author-not-found")
class AuthorNotFound : RuntimeException()

@ErrorCode("book-not-found")
class BookNotFound : RuntimeException()
