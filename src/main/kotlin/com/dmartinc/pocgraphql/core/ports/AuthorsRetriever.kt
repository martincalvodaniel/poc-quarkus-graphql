package com.dmartinc.pocgraphql.core.ports

import com.dmartinc.pocgraphql.core.Author

interface AuthorsRetriever {
    fun retrieve(): List<Author>
}
