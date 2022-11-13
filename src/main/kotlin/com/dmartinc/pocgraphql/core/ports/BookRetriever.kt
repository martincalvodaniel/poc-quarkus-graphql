package com.dmartinc.pocgraphql.core.ports

import com.dmartinc.pocgraphql.core.Book

interface BookRetriever {
    fun retrieveOne(id: Int): Book?
}
