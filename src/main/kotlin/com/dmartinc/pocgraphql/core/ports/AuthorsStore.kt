package com.dmartinc.pocgraphql.core.ports

import com.dmartinc.pocgraphql.core.AuthorToCreate

interface AuthorsStore {
    fun store(authorToCreate: AuthorToCreate)
}
