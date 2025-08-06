package com.federated;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import federated.FederatedServiceGrpc;
import federated.Federated.ModelWeights;

import java.io.IOException;


public class FederatedServer {
    
    private static final int SERVER_PORT = 50051;


    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(SERVER_PORT)
            .addService(new FederatedServiceImpl())
            .build();

        System.out.println("Server started on port " + SERVER_PORT);
        server.start();
        server.awaitTermination();
    }

    static class FederatedServiceImpl extends FederatedServiceGrpc.FederatedServiceImplBase {
        @Override
        public void sendWeights(ModelWeights request, StreamObserver<ModelWeights> responseObserver) {
            System.out.println("Received weights: " + request.getWeightsList());

            // Just echo back for now
            ModelWeights response = ModelWeights.newBuilder()
                .addAllWeights(request.getWeightsList())
                .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}
