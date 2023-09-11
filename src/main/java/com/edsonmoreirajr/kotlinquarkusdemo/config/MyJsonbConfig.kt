package com.edsonmoreirajr.kotlinquarkusdemo.config

import io.quarkus.jsonb.JsonbConfigCustomizer
import jakarta.enterprise.context.ApplicationScoped
import jakarta.json.bind.JsonbConfig

@ApplicationScoped
class MyJsonbConfig : JsonbConfigCustomizer {
    override fun customize(config: JsonbConfig) {
        config.withDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", null)
    }
}