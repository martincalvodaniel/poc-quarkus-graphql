package com.dmartinc.pocgraphql.core

import org.slf4j.Logger
import org.slf4j.LoggerFactory

object Utils {

    inline fun <reified T> T.logger(): Logger {
        return LoggerFactory.getLogger(T::class.java)
    }
}
