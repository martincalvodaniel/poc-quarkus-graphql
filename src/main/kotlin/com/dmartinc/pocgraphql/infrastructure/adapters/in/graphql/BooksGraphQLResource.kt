package com.dmartinc.pocgraphql.infrastructure.adapters.`in`.graphql

import com.dmartinc.pocgraphql.core.usecases.actions.CreateBook
import com.dmartinc.pocgraphql.core.usecases.actions.DeleteBook
import com.dmartinc.pocgraphql.core.usecases.queries.FindBook
import com.dmartinc.pocgraphql.core.usecases.queries.FindBooks
import com.dmartinc.pocgraphql.core.usecases.queries.FindBooksByAuthorId
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Mutation
import org.eclipse.microprofile.graphql.Query
import org.eclipse.microprofile.graphql.Source
import javax.transaction.Transactional

@GraphQLApi
class BooksGraphQLResource(
    private val createBook: CreateBook,
    private val deleteBook: DeleteBook,
    private val findBook: FindBook,
    private val findBooks: FindBooks,
    private val findBooksByAuthorId: FindBooksByAuthorId
) {

    @Transactional
    @Mutation
    fun createBook(book: BookDto): Boolean {
        createBook.execute(book.toDomain())
        return true
    }

    @Transactional
    @Mutation
    fun deleteBook(id: Int): Boolean {
        deleteBook.execute(id)
        return true
    }

    @Query
    fun findBook(id: Int): BookDto = findBook.query(id).let { BookDto.fromDomain(it) }

    @Query
    fun findBooks(): BooksDto = BooksDto.fromDomain(findBooks.query())

    @Query("books")
    fun findBooksForAuthor(@Source authorDto: AuthorDto): List<BookDto> =
        findBooksByAuthorId.query(authorDto.id!!).map { BookDto.fromDomain(it) }
}
