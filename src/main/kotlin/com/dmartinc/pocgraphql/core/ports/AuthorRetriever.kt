package com.dmartinc.pocgraphql.core.ports

import com.dmartinc.pocgraphql.core.Author

interface AuthorRetriever {
    fun retrieve(id: Int): Author?
}
