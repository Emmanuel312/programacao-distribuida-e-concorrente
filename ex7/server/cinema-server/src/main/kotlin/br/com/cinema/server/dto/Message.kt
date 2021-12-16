package br.com.cinema.server.dto

import kotlinx.serialization.Serializable

@Serializable
data class Message(val op: Op, val number : Int? = 0)