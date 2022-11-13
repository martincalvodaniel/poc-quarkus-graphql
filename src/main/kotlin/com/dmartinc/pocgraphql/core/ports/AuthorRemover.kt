package com.dmartinc.pocgraphql.core.ports

interface AuthorRemover {
    fun remove(id: Int): Boolean
}
