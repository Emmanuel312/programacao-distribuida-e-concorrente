package br.com.cinema.server.grpc

import io.grpc.BindableService
import io.grpc.Server
import io.grpc.ServerBuilder
import java.util.concurrent.Executors

class Server(val port: Int, val services: MutableList<BindableService>) {

    fun start() {
        server.start()
        println("Server started, listening on $port")
        Runtime.getRuntime().addShutdownHook(
            Thread {
                println("*** shutting down gRPC server since JVM is shutting down")
                this@Server.stop()
                println("*** server shut down")
            }
        )
    }

    private fun stop() {
        server.shutdown()
    }

    fun blockUntilShutdown() {
        server.awaitTermination()
    }

    fun configure() {
        val serverBuilder = ServerBuilder
            .forPort(port)
            .executor(Executors.newFixedThreadPool(10))

        services.forEach {
            serverBuilder.addService(it)
        }

        server = serverBuilder.build()
    }

    companion object {
        lateinit var server: Server
    }
}