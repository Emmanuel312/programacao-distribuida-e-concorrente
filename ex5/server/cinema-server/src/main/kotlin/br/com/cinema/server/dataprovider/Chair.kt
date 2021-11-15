package br.com.cinema.server.dataprovider

import kotlinx.serialization.Serializable

@Serializable
data class Chair(
    val number: Int,
    val available: Boolean
)
