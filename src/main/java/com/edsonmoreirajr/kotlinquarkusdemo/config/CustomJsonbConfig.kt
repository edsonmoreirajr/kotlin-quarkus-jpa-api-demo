package com.edsonmoreirajr.kotlinquarkusdemo.config

import io.quarkus.jsonb.JsonbConfigCustomizer
import jakarta.enterprise.context.Dependent
import jakarta.enterprise.inject.Instance
import jakarta.json.bind.JsonbConfig

class CustomJsonbConfig {
    @Dependent
    fun jsonConfig(customizers: Instance<JsonbConfigCustomizer>): JsonbConfig {
        val config: JsonbConfig = myJsonbConfig()

        for (customizer in customizers) {
            customizer.customize(config)
        }
        return config
    }

    private fun myJsonbConfig(): JsonbConfig {
        val config = JsonbConfig()
        config.withDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", null)
        return config
    }
}