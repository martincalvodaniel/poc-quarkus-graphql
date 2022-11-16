# poc-quarkus-graphql Project

<p align="center">
  <a href="https://gradle.org"><img src="https://img.shields.io/badge/Gradle-022E38?style=for-the-badge"></a>
  <a href="https://kotlinlang.org"><img src="https://img.shields.io/badge/Kotlin-E77825?style=for-the-badge"></a>
  <a href="https://quarkus.io"><img src="https://img.shields.io/badge/Quarkus-091213?style=for-the-badge"></a>
  <a href="https://graphql.org"><img src="https://img.shields.io/badge/GraphQL-D932A2?style=for-the-badge"></a>

[//]: # (  <a href="https://www.mongodb.com"><img src="https://img.shields.io/badge/MongoDB-81C564?style=for-the-badge"></a>)
</p>

This project started as a `Proof of concept of a graphql api which queries an in-memory H2 database populated at
startup.` but it has evolved into:
* A demonstration of Hexagonal Architecture (obviously from my point of view and with some very simple use cases)
* Additional to the GraphQL layer, a RESTful API has been implemented as a new port-in to the application logic 

This project uses [Quarkus](https://quarkus.io), the Supersonic Subatomic Java Framework.

## Available GraphQL Queries

Once the application has been started:
    * the GraphQL api can be friendly queried at [graphql-ui](http://localhost:8080/q/graphql-ui)
    * the GraphQL schema can be queried at [schema.graphql](http://localhost:8080/graphql/schema.graphql)

```
# query{findAuthors{authors{id name country books{id authorId title summary}}}}
# query{findAuthor(id: "1"){id name country books{id authorId title summary}}}
# mutation{createAuthor(author:{name:"author4", country:"author4Country"})}
# mutation{deleteAuthor(id: "3")}

# query{findBooks{books{id authorId title summary}}}
# query{findBook(id: "1"){id authorId title summary}}
# mutation{createBook(book:{authorId:"1", title:"author1book6Title", summary:"author1book6Summary"})}
# mutation{deleteBook(id: "5")}
```

Executing this queries will result in request and responses as exposed in [graphQLQueries](doc/graphQLQueries.md).

## Available Rest Endpoints

Once the application has been started, the available rest endpoints can be used at
[swagger](http://localhost:8080/q/documentation).

[Postman](https://www.postman.com) collection can be imported too with this [openapi](http://localhost:8080/openapi)
file.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./gradlew quarkusDev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./gradlew build
```
It produces the `quarkus-run.jar` file in the `build/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `build/quarkus-app/lib/` directory.

The application is now runnable using `java -jar build/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./gradlew build -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar build/*-runner.jar`.

## Related Guides

- JDBC Driver - H2 ([guide](https://quarkus.io/guides/datasource)): Connect to the H2 database via JDBC
- Kotlin ([guide](https://quarkus.io/guides/kotlin)): Write your services in Kotlin
- SmallRye GraphQL ([guide](https://quarkus.io/guides/microprofile-graphql)): Create GraphQL Endpoints using the
code-first approach from MicroProfile GraphQL
