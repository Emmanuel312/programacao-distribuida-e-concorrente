package br.com.cinema.server.dto

data class Message(
    val op: Op,
    val number: Int? = 0
)