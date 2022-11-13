package com.dmartinc.pocgraphql.core.ports

interface BookRemover {
    fun remove(bookId: Int): Boolean
}
