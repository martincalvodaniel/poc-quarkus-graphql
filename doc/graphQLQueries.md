# GraphQL operations

## Queries

### FindAuthors
```shell script
curl --location --request POST 'http://localhost:8080/graphql' \
--header 'Content-Type: application/json' \
--data-raw '{
"query": "query{findAuthors{authors{id name country books{id authorId title summary}}}}"
}'
```

```json
{
  "data": {
    "findAuthors": {
      "authors": [
        {
          "id": "1",
          "name": "J.R.R. Tolkien",
          "country": "UK",
          "books": [
            {
              "id": "1",
              "authorId": "1",
              "title": "El hobbit",
              "summary": "El hobbit es una novela fantástica del filólogo y escritor británico J. R. R. Tolkien. Fue escrita por partes desde finales de los años 1920 hasta principios de los años 1930 y, en un principio, tan solo tenía el objetivo de divertir a los hijos pequeños de Tolkien."
            },
            {
              "id": "2",
              "authorId": "1",
              "title": "El Silmarillion",
              "summary": "El Silmarillion es una recopilación de obras de J. R. R. Tolkien, editada y publicada póstumamente por su hijo Christopher Tolkien, en 1977. En ella se narra, entre otras cosas, la creación de Eä y el nacimiento de las razas más importantes de Arda."
            }
          ]
        },
        {
          "id": "2",
          "name": "George R. R. Martin",
          "country": "USA",
          "books": [
            {
              "id": "3",
              "authorId": "2",
              "title": "Canción de hielo y fuego",
              "summary": "Canción de hielo y fuego es una multipremiada serie de novelas de fantasía heroica escritas por el novelista y guionista estadounidense George R. R. Martin. Martin comenzó a escribir la serie en 1993 y el primer tomo se publicó en 1996."
            },
            {
              "id": "4",
              "authorId": "2",
              "title": "Juego de tronos",
              "summary": "Juego de tronos es una novela de fantasía escrita por el autor estadounidense George R. R. Martin en 1996 y ganadora del premio Locus a la mejor novela de fantasía en 1997. Se trata de la primera entrega de la serie de gran popularidad Canción de hielo y fuego."
            }
          ]
        },
        {
          "id": "3",
          "name": "J. K. Rowling",
          "country": "UK",
          "books": [
            {
              "id": "5",
              "authorId": "3",
              "title": "Harry Potter",
              "summary": "Harry vive debajo de la escalera. (ya sabeis de que va esto)"
            }
          ]
        }
      ]
    }
  }
}
```

### FindAuthor
```shell script
curl --location --request POST 'http://localhost:8080/graphql' \
--header 'Content-Type: application/json' \
--data-raw '{
"query": "query{findAuthor(id: \"1\"){name country books{id title summary}}}"
}'
```
```json
{
  "data": {
    "findAuthor": {
      "name": "J.R.R. Tolkien",
      "country": "UK",
      "books": [
        {
          "id": "1",
          "title": "El hobbit",
          "summary": "El hobbit es una novela fantástica del filólogo y escritor británico J. R. R. Tolkien. Fue escrita por partes desde finales de los años 1920 hasta principios de los años 1930 y, en un principio, tan solo tenía el objetivo de divertir a los hijos pequeños de Tolkien."
        },
        {
          "id": "2",
          "title": "El Silmarillion",
          "summary": "El Silmarillion es una recopilación de obras de J. R. R. Tolkien, editada y publicada póstumamente por su hijo Christopher Tolkien, en 1977. En ella se narra, entre otras cosas, la creación de Eä y el nacimiento de las razas más importantes de Arda."
        }
      ]
    }
  }
}
```

### FindBooks
```shell script
curl --location --request POST 'http://localhost:8080/graphql' \
--header 'Content-Type: application/json' \
--data-raw '{
"query": "query{findBooks{books{id authorId title summary}}}"
}'
```
```json
{
  "data": {
    "findBooks": {
      "books": [
        {
          "id": "1",
          "authorId": "1",
          "title": "El hobbit",
          "summary": "El hobbit es una novela fantástica del filólogo y escritor británico J. R. R. Tolkien. Fue escrita por partes desde finales de los años 1920 hasta principios de los años 1930 y, en un principio, tan solo tenía el objetivo de divertir a los hijos pequeños de Tolkien."
        },
        {
          "id": "2",
          "authorId": "1",
          "title": "El Silmarillion",
          "summary": "El Silmarillion es una recopilación de obras de J. R. R. Tolkien, editada y publicada póstumamente por su hijo Christopher Tolkien, en 1977. En ella se narra, entre otras cosas, la creación de Eä y el nacimiento de las razas más importantes de Arda."
        },
        {
          "id": "3",
          "authorId": "2",
          "title": "Canción de hielo y fuego",
          "summary": "Canción de hielo y fuego es una multipremiada serie de novelas de fantasía heroica escritas por el novelista y guionista estadounidense George R. R. Martin. Martin comenzó a escribir la serie en 1993 y el primer tomo se publicó en 1996."
        },
        {
          "id": "4",
          "authorId": "2",
          "title": "Juego de tronos",
          "summary": "Juego de tronos es una novela de fantasía escrita por el autor estadounidense George R. R. Martin en 1996 y ganadora del premio Locus a la mejor novela de fantasía en 1997. Se trata de la primera entrega de la serie de gran popularidad Canción de hielo y fuego."
        },
        {
          "id": "5",
          "authorId": "3",
          "title": "Harry Potter",
          "summary": "Harry vive debajo de la escalera. (ya sabeis de que va esto)"
        }
      ]
    }
  }
}
```

### FindBook
```shell script
curl --location --request POST 'http://localhost:8080/graphql' \
--header 'Content-Type: application/json' \
--data-raw '{
"query": "query{findBook(id: \"1\"){id authorId title summary}}"
}'
```

```json
{
  "data": {
    "findBook": {
      "id": "1",
      "authorId": "1",
      "title": "El hobbit",
      "summary": "El hobbit es una novela fantástica del filólogo y escritor británico J. R. R. Tolkien. Fue escrita por partes desde finales de los años 1920 hasta principios de los años 1930 y, en un principio, tan solo tenía el objetivo de divertir a los hijos pequeños de Tolkien."
    }
  }
}
```

## Mutations

### createAuthor
```shell script
curl --location --request POST 'http://localhost:8080/graphql' \
--header 'Content-Type: application/json' \
--data-raw '{
"query": "mutation{createAuthor(author:{name:\"author4\", country:\"author4Country\"})}"
}'
```

```json
{
  "data": {
    "createAuthor": true
  }
}
```

### deleteAuthor
```shell script
curl --location --request POST 'http://localhost:8080/graphql' \
--header 'Content-Type: application/json' \
--data-raw '{
"query": "mutation{deleteAuthor(id: \"3\")}"
}'
```

```json
{
  "data": {
    "deleteAuthor": true
  }
}
```

### createBook
```shell script
curl --location --request POST 'http://localhost:8080/graphql' \
--header 'Content-Type: application/json' \
--data-raw '{
"query": "mutation{createBook(book:{authorId:\"1\", title:\"author1book6Title\", summary:\"author1book6Summary\"})}"
}'
```

```json
{
  "data": {
    "createBook": true
  }
}
```

### deleteBook
```shell script
curl --location --request POST 'http://localhost:8080/graphql' \
--header 'Content-Type: application/json' \
--data-raw '{
"query": "mutation{deleteBook(id: \"5\")}"
}'
```

```json
{
  "data": {
    "deleteBook": true
  }
}
```