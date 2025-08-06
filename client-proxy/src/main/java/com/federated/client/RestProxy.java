package com.federated.client;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@RestController
public class RestProxy {

    private final GrpcService grpcService;

    public RestProxy(GrpcService grpcService) {
        this.grpcService = grpcService;
    }

    @GetMapping("/download")
    public String downloadGlobalModel() throws IOException {
        grpcService.fetchGlobalModel();
        return Files.readString(Paths.get("shared/global_weights.json"));
    }

    @PostMapping("/upload")
    public String uploadLocalModel(@RequestBody Map<String, Object> payload) {
        List<Double> weights = (List<Double>) payload.get("weights");
        grpcService.sendLocalWeights(weights.stream().map(Double::floatValue).toList());
        return "{\"status\":\"weights sent to server\"}";
    }
}
