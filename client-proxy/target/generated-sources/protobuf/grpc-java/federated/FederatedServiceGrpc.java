package federated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.64.0)",
    comments = "Source: federated.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FederatedServiceGrpc {

  private FederatedServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "federated.FederatedService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<federated.Federated.ModelWeights,
      federated.Federated.ModelWeights> getSendWeightsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendWeights",
      requestType = federated.Federated.ModelWeights.class,
      responseType = federated.Federated.ModelWeights.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<federated.Federated.ModelWeights,
      federated.Federated.ModelWeights> getSendWeightsMethod() {
    io.grpc.MethodDescriptor<federated.Federated.ModelWeights, federated.Federated.ModelWeights> getSendWeightsMethod;
    if ((getSendWeightsMethod = FederatedServiceGrpc.getSendWeightsMethod) == null) {
      synchronized (FederatedServiceGrpc.class) {
        if ((getSendWeightsMethod = FederatedServiceGrpc.getSendWeightsMethod) == null) {
          FederatedServiceGrpc.getSendWeightsMethod = getSendWeightsMethod =
              io.grpc.MethodDescriptor.<federated.Federated.ModelWeights, federated.Federated.ModelWeights>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendWeights"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  federated.Federated.ModelWeights.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  federated.Federated.ModelWeights.getDefaultInstance()))
              .setSchemaDescriptor(new FederatedServiceMethodDescriptorSupplier("SendWeights"))
              .build();
        }
      }
    }
    return getSendWeightsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FederatedServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FederatedServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FederatedServiceStub>() {
        @java.lang.Override
        public FederatedServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FederatedServiceStub(channel, callOptions);
        }
      };
    return FederatedServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FederatedServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FederatedServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FederatedServiceBlockingStub>() {
        @java.lang.Override
        public FederatedServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FederatedServiceBlockingStub(channel, callOptions);
        }
      };
    return FederatedServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FederatedServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FederatedServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FederatedServiceFutureStub>() {
        @java.lang.Override
        public FederatedServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FederatedServiceFutureStub(channel, callOptions);
        }
      };
    return FederatedServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void sendWeights(federated.Federated.ModelWeights request,
        io.grpc.stub.StreamObserver<federated.Federated.ModelWeights> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendWeightsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service FederatedService.
   */
  public static abstract class FederatedServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return FederatedServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service FederatedService.
   */
  public static final class FederatedServiceStub
      extends io.grpc.stub.AbstractAsyncStub<FederatedServiceStub> {
    private FederatedServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FederatedServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FederatedServiceStub(channel, callOptions);
    }

    /**
     */
    public void sendWeights(federated.Federated.ModelWeights request,
        io.grpc.stub.StreamObserver<federated.Federated.ModelWeights> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendWeightsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service FederatedService.
   */
  public static final class FederatedServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FederatedServiceBlockingStub> {
    private FederatedServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FederatedServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FederatedServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public federated.Federated.ModelWeights sendWeights(federated.Federated.ModelWeights request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendWeightsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service FederatedService.
   */
  public static final class FederatedServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<FederatedServiceFutureStub> {
    private FederatedServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FederatedServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FederatedServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<federated.Federated.ModelWeights> sendWeights(
        federated.Federated.ModelWeights request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendWeightsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_WEIGHTS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_WEIGHTS:
          serviceImpl.sendWeights((federated.Federated.ModelWeights) request,
              (io.grpc.stub.StreamObserver<federated.Federated.ModelWeights>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSendWeightsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              federated.Federated.ModelWeights,
              federated.Federated.ModelWeights>(
                service, METHODID_SEND_WEIGHTS)))
        .build();
  }

  private static abstract class FederatedServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FederatedServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return federated.Federated.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FederatedService");
    }
  }

  private static final class FederatedServiceFileDescriptorSupplier
      extends FederatedServiceBaseDescriptorSupplier {
    FederatedServiceFileDescriptorSupplier() {}
  }

  private static final class FederatedServiceMethodDescriptorSupplier
      extends FederatedServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    FederatedServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (FederatedServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FederatedServiceFileDescriptorSupplier())
              .addMethod(getSendWeightsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
