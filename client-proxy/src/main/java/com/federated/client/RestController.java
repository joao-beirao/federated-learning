package com.federated.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@RestController
public class RestController {

    @Autowired
    private GrpcService grpcService;

    private final String GLOBAL_FILE = "shared/global_weights.json";

    // Endpoint for Python to download global weights
    @GetMapping("/download")
    public String downloadGlobalModel() throws IOException {
        grpcService.fetchGlobalModel();
        return Files.readString(Paths.get(GLOBAL_FILE));
    }

    // Endpoint for Python to upload new weights
    @PostMapping("/upload")
    public String uploadLocalModel(@RequestBody Map<String, Object> payload) {
        List<Double> weights = (List<Double>) payload.get("weights");
        grpcService.sendLocalWeights(weights.stream().map(Double::floatValue).toList());
        return "{\"status\":\"weights sent to server\"}";
    }
}
