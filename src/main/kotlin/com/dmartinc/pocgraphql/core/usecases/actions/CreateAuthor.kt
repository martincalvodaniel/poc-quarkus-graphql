package com.dmartinc.pocgraphql.core.usecases.actions

import com.dmartinc.pocgraphql.core.Author
import com.dmartinc.pocgraphql.core.ports.AuthorsStore

class CreateAuthor(private val authorsStore: AuthorsStore) {

    fun execute(author: Author) {
        authorsStore.store(author)
    }
}
