package com.federated.client;

import federated.FederatedServiceGrpc;
import federated.Federated.ModelWeights;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class GrpcService {

    private final FederatedServiceGrpc.FederatedServiceBlockingStub stub;
    private final String GLOBAL_FILE = "shared/global_weights.json";

    public GrpcService() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();
        stub = FederatedServiceGrpc.newBlockingStub(channel);
    }

    // Pull global weights from server and save to file
    public void fetchGlobalModel() throws IOException {
        ModelWeights response = stub.sendWeights(ModelWeights.newBuilder().build()); // dummy request
        saveWeightsToFile(response.getWeightsList(), GLOBAL_FILE);
    }

    // Send local weights to server
    public void sendLocalWeights(List<Float> weights) {
        ModelWeights request = ModelWeights.newBuilder()
                .addAllWeights(weights)
                .build();
        stub.sendWeights(request);
    }

    private void saveWeightsToFile(List<Float> weights, String filePath) throws IOException {
        String json = "{\"weights\":" + weights.toString() + "}";
        Files.createDirectories(Paths.get("shared"));
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(json);
        }
    }
}
