package br.com.cinema.server

import br.com.cinema.server.CinemaGrpc.getServiceDescriptor
import io.grpc.CallOptions
import io.grpc.CallOptions.DEFAULT
import io.grpc.Channel
import io.grpc.Metadata
import io.grpc.MethodDescriptor
import io.grpc.ServerServiceDefinition
import io.grpc.ServerServiceDefinition.builder
import io.grpc.ServiceDescriptor
import io.grpc.Status
import io.grpc.Status.UNIMPLEMENTED
import io.grpc.StatusException
import io.grpc.kotlin.AbstractCoroutineServerImpl
import io.grpc.kotlin.AbstractCoroutineStub
import io.grpc.kotlin.ClientCalls
import io.grpc.kotlin.ClientCalls.unaryRpc
import io.grpc.kotlin.ServerCalls
import io.grpc.kotlin.ServerCalls.unaryServerMethodDefinition
import io.grpc.kotlin.StubFor
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * Holder for Kotlin coroutine-based client and server APIs for br.com.cinema.server.Cinema.
 */
object CinemaGrpcKt {
  @JvmStatic
  val serviceDescriptor: ServiceDescriptor
    get() = CinemaGrpc.getServiceDescriptor()

  val buyTicketMethod: MethodDescriptor<BuyTicketRequest, AvailableChairReply>
    @JvmStatic
    get() = CinemaGrpc.getBuyTicketMethod()

  val listAllAvailableChairsMethod: MethodDescriptor<Empty, ChairList>
    @JvmStatic
    get() = CinemaGrpc.getListAllAvailableChairsMethod()

  /**
   * A stub for issuing RPCs to a(n) br.com.cinema.server.Cinema service as suspending coroutines.
   */
  @StubFor(CinemaGrpc::class)
  class CinemaCoroutineStub @JvmOverloads constructor(
    channel: Channel,
    callOptions: CallOptions = DEFAULT
  ) : AbstractCoroutineStub<CinemaCoroutineStub>(channel, callOptions) {
    override fun build(channel: Channel, callOptions: CallOptions): CinemaCoroutineStub =
        CinemaCoroutineStub(channel, callOptions)

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @return The single response from the server.
     */
    suspend fun buyTicket(request: BuyTicketRequest): AvailableChairReply = unaryRpc(
      channel,
      CinemaGrpc.getBuyTicketMethod(),
      request,
      callOptions,
      Metadata()
    )
    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @return The single response from the server.
     */
    suspend fun listAllAvailableChairs(request: Empty): ChairList = unaryRpc(
      channel,
      CinemaGrpc.getListAllAvailableChairsMethod(),
      request,
      callOptions,
      Metadata()
    )}

  /**
   * Skeletal implementation of the br.com.cinema.server.Cinema service based on Kotlin coroutines.
   */
  abstract class CinemaCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns the response to an RPC for br.com.cinema.server.Cinema.buyTicket.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    open suspend fun buyTicket(request: BuyTicketRequest): AvailableChairReply = throw
        StatusException(UNIMPLEMENTED.withDescription("Method br.com.cinema.server.Cinema.buyTicket is unimplemented"))

    /**
     * Returns the response to an RPC for br.com.cinema.server.Cinema.listAllAvailableChairs.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    open suspend fun listAllAvailableChairs(request: Empty): ChairList = throw
        StatusException(UNIMPLEMENTED.withDescription("Method br.com.cinema.server.Cinema.listAllAvailableChairs is unimplemented"))

    final override fun bindService(): ServerServiceDefinition = builder(getServiceDescriptor())
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = CinemaGrpc.getBuyTicketMethod(),
      implementation = ::buyTicket
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = CinemaGrpc.getListAllAvailableChairsMethod(),
      implementation = ::listAllAvailableChairs
    )).build()
  }
}
