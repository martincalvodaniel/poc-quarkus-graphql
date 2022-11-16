package com.dmartinc.pocgraphql.core.usecases.actions

import com.dmartinc.pocgraphql.core.AuthorToCreate
import com.dmartinc.pocgraphql.core.ports.AuthorsStore

class CreateAuthor(private val authorsStore: AuthorsStore) {

    fun execute(authorToCreate: AuthorToCreate) {
        authorsStore.store(authorToCreate)
    }
}
