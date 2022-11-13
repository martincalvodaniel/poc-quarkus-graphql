package com.dmartinc.pocgraphql.core

import io.smallrye.graphql.api.ErrorCode

@ErrorCode("author-not-found")
class AuthorNotFound(authorId: Int) : RuntimeException("Author with id='$authorId' not found")

@ErrorCode("book-not-found")
class BookNotFound(bookId: Int) : RuntimeException("Book with id='$bookId' not found")
