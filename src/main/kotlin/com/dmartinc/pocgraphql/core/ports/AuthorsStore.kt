package com.dmartinc.pocgraphql.core.ports

import com.dmartinc.pocgraphql.core.Author

interface AuthorsStore {
    fun store(author: Author)
}
