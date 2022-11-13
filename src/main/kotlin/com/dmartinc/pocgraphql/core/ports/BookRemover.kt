package com.dmartinc.pocgraphql.core.ports

interface BookRemover {
    fun remove(id: Int): Boolean
}
