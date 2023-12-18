package com.example.devopsexampractical.v1.utils;

import com.example.devopsexampractical.v1.dtos.requests.DoMathRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

public class TestUtils {
    public static HttpEntity<DoMathRequest> createHttpEntity(DoMathRequest doMathRequest) {
        HttpHeaders headers = new HttpHeaders();
        // Add headers if needed

        // Create an HttpEntity with the new item data and headers
        HttpEntity<DoMathRequest> requestEntity = new HttpEntity<>(doMathRequest, headers);

        return requestEntity;
    }

}
