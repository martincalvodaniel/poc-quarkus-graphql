package com.dmartinc.pocgraphql.core

data class Author(val id: String, val name: String, val country: String)

data class Book(val id: String, val authorId: String, val title: String, val summary: String)
