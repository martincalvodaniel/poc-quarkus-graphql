package com.dmartinc.pocgraphql.core.ports

import com.dmartinc.pocgraphql.core.Author

interface AuthorByIdRetriever {
    fun retrieve(id: Int): Author?
}
