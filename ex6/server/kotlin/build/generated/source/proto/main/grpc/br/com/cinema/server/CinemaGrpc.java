package br.com.cinema.server;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.25.0)",
    comments = "Source: grpc.proto")
public final class CinemaGrpc {

  private CinemaGrpc() {}

  public static final String SERVICE_NAME = "br.com.cinema.server.Cinema";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<br.com.cinema.server.BuyTicketRequest,
      br.com.cinema.server.AvailableChairReply> getBuyTicketMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "buyTicket",
      requestType = br.com.cinema.server.BuyTicketRequest.class,
      responseType = br.com.cinema.server.AvailableChairReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<br.com.cinema.server.BuyTicketRequest,
      br.com.cinema.server.AvailableChairReply> getBuyTicketMethod() {
    io.grpc.MethodDescriptor<br.com.cinema.server.BuyTicketRequest, br.com.cinema.server.AvailableChairReply> getBuyTicketMethod;
    if ((getBuyTicketMethod = CinemaGrpc.getBuyTicketMethod) == null) {
      synchronized (CinemaGrpc.class) {
        if ((getBuyTicketMethod = CinemaGrpc.getBuyTicketMethod) == null) {
          CinemaGrpc.getBuyTicketMethod = getBuyTicketMethod =
              io.grpc.MethodDescriptor.<br.com.cinema.server.BuyTicketRequest, br.com.cinema.server.AvailableChairReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "buyTicket"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.cinema.server.BuyTicketRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.cinema.server.AvailableChairReply.getDefaultInstance()))
              .setSchemaDescriptor(new CinemaMethodDescriptorSupplier("buyTicket"))
              .build();
        }
      }
    }
    return getBuyTicketMethod;
  }

  private static volatile io.grpc.MethodDescriptor<br.com.cinema.server.Empty,
      br.com.cinema.server.ChairList> getListAllAvailableChairsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "listAllAvailableChairs",
      requestType = br.com.cinema.server.Empty.class,
      responseType = br.com.cinema.server.ChairList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<br.com.cinema.server.Empty,
      br.com.cinema.server.ChairList> getListAllAvailableChairsMethod() {
    io.grpc.MethodDescriptor<br.com.cinema.server.Empty, br.com.cinema.server.ChairList> getListAllAvailableChairsMethod;
    if ((getListAllAvailableChairsMethod = CinemaGrpc.getListAllAvailableChairsMethod) == null) {
      synchronized (CinemaGrpc.class) {
        if ((getListAllAvailableChairsMethod = CinemaGrpc.getListAllAvailableChairsMethod) == null) {
          CinemaGrpc.getListAllAvailableChairsMethod = getListAllAvailableChairsMethod =
              io.grpc.MethodDescriptor.<br.com.cinema.server.Empty, br.com.cinema.server.ChairList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "listAllAvailableChairs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.cinema.server.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.cinema.server.ChairList.getDefaultInstance()))
              .setSchemaDescriptor(new CinemaMethodDescriptorSupplier("listAllAvailableChairs"))
              .build();
        }
      }
    }
    return getListAllAvailableChairsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CinemaStub newStub(io.grpc.Channel channel) {
    return new CinemaStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CinemaBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CinemaBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CinemaFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CinemaFutureStub(channel);
  }

  /**
   */
  public static abstract class CinemaImplBase implements io.grpc.BindableService {

    /**
     */
    public void buyTicket(br.com.cinema.server.BuyTicketRequest request,
        io.grpc.stub.StreamObserver<br.com.cinema.server.AvailableChairReply> responseObserver) {
      asyncUnimplementedUnaryCall(getBuyTicketMethod(), responseObserver);
    }

    /**
     */
    public void listAllAvailableChairs(br.com.cinema.server.Empty request,
        io.grpc.stub.StreamObserver<br.com.cinema.server.ChairList> responseObserver) {
      asyncUnimplementedUnaryCall(getListAllAvailableChairsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getBuyTicketMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                br.com.cinema.server.BuyTicketRequest,
                br.com.cinema.server.AvailableChairReply>(
                  this, METHODID_BUY_TICKET)))
          .addMethod(
            getListAllAvailableChairsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                br.com.cinema.server.Empty,
                br.com.cinema.server.ChairList>(
                  this, METHODID_LIST_ALL_AVAILABLE_CHAIRS)))
          .build();
    }
  }

  /**
   */
  public static final class CinemaStub extends io.grpc.stub.AbstractStub<CinemaStub> {
    private CinemaStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CinemaStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CinemaStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CinemaStub(channel, callOptions);
    }

    /**
     */
    public void buyTicket(br.com.cinema.server.BuyTicketRequest request,
        io.grpc.stub.StreamObserver<br.com.cinema.server.AvailableChairReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBuyTicketMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listAllAvailableChairs(br.com.cinema.server.Empty request,
        io.grpc.stub.StreamObserver<br.com.cinema.server.ChairList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListAllAvailableChairsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CinemaBlockingStub extends io.grpc.stub.AbstractStub<CinemaBlockingStub> {
    private CinemaBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CinemaBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CinemaBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CinemaBlockingStub(channel, callOptions);
    }

    /**
     */
    public br.com.cinema.server.AvailableChairReply buyTicket(br.com.cinema.server.BuyTicketRequest request) {
      return blockingUnaryCall(
          getChannel(), getBuyTicketMethod(), getCallOptions(), request);
    }

    /**
     */
    public br.com.cinema.server.ChairList listAllAvailableChairs(br.com.cinema.server.Empty request) {
      return blockingUnaryCall(
          getChannel(), getListAllAvailableChairsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CinemaFutureStub extends io.grpc.stub.AbstractStub<CinemaFutureStub> {
    private CinemaFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CinemaFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CinemaFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CinemaFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<br.com.cinema.server.AvailableChairReply> buyTicket(
        br.com.cinema.server.BuyTicketRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBuyTicketMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<br.com.cinema.server.ChairList> listAllAvailableChairs(
        br.com.cinema.server.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getListAllAvailableChairsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_BUY_TICKET = 0;
  private static final int METHODID_LIST_ALL_AVAILABLE_CHAIRS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CinemaImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CinemaImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BUY_TICKET:
          serviceImpl.buyTicket((br.com.cinema.server.BuyTicketRequest) request,
              (io.grpc.stub.StreamObserver<br.com.cinema.server.AvailableChairReply>) responseObserver);
          break;
        case METHODID_LIST_ALL_AVAILABLE_CHAIRS:
          serviceImpl.listAllAvailableChairs((br.com.cinema.server.Empty) request,
              (io.grpc.stub.StreamObserver<br.com.cinema.server.ChairList>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CinemaBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CinemaBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return br.com.cinema.server.GrpcProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Cinema");
    }
  }

  private static final class CinemaFileDescriptorSupplier
      extends CinemaBaseDescriptorSupplier {
    CinemaFileDescriptorSupplier() {}
  }

  private static final class CinemaMethodDescriptorSupplier
      extends CinemaBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CinemaMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CinemaGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CinemaFileDescriptorSupplier())
              .addMethod(getBuyTicketMethod())
              .addMethod(getListAllAvailableChairsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
