# poc-quarkus-graphql Project

Proof of concept of a graphql api which queries an in-memory H2 database populated at startup.

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Available GraphQL Queries
```
# query{findAuthors{authors{id name country books{id authorId title summary}}}}
# query{findAuthor(id: "1"){id name country books{id authorId title summary}}}
# mutation{createAuthor(author:{id:"4", name:"author4", country:"author4Country"})}
# mutation{deleteAuthor(id: "3")}

# query{findBooks{books{id authorId title summary}}}
# query{findBook(id: "1"){id authorId title summary}}
# mutation{createBook(book:{id:"6", authorId:"1", title:"author1book6Title", summary:"author1book6Summary"})}
# mutation{deleteBook(id: "5")}
```

Once the application has been started, the GraphQL api can be queried here: http://localhost:8080/q/graphql-ui

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
