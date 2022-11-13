package com.dmartinc.pocgraphql.core.usecases.actions

import com.dmartinc.pocgraphql.core.AuthorNotFound
import com.dmartinc.pocgraphql.core.ports.AuthorRemover

class DeleteAuthor(private val authorRemover: AuthorRemover) {

    fun execute(authorId: Int) {
        if (authorRemover.remove(authorId).not()) {
            throw AuthorNotFound(authorId)
        }
    }
}
