package br.com.cinema.server.dataprovider

import com.fasterxml.jackson.annotation.JsonProperty

data class Chair(
    @field:JsonProperty
    val number: Int,
    @field:JsonProperty
    val available: Boolean
)
