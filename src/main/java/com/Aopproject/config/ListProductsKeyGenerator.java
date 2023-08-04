package com.Aopproject.config;

import java.lang.reflect.Method;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ListProductsKeyGenerator implements KeyGenerator {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Object generate(Object target, Method method, Object... params) {
        try {
            return objectMapper.writeValueAsString(params[0]);
        } catch (JsonProcessingException e) {
            // Handle JSON processing exception if necessary
            e.printStackTrace();
        }
        return null;
    }
}