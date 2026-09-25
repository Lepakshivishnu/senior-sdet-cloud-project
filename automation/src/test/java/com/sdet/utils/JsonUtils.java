package com.sdet.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.io.InputStream;

public class JsonUtils {

    private static final ObjectMapper OBJECT_MAPPER =
            new ObjectMapper();

    public static JsonNode readJson(String fileName) {

        try (InputStream inputStream =
                     JsonUtils.class
                             .getClassLoader()
                             .getResourceAsStream("testdata/" + fileName)) {

            if (inputStream == null) {
                throw new RuntimeException(
                        "JSON file not found: " + fileName);
            }

            return OBJECT_MAPPER.readTree(inputStream);

        } catch (IOException e) {
            throw new RuntimeException(
                    "Failed to read JSON file: " + fileName, e);
        }
    }

    public static void setField(
            JsonNode json,
            String fieldName,
            String value) {

        ((ObjectNode) json).put(fieldName, value);
    }

    public static void setField(
            JsonNode json,
            String fieldName,
            int value) {

        ((ObjectNode) json).put(fieldName, value);
    }

    public static void setField(
            JsonNode json,
            String fieldName,
            boolean value) {

        ((ObjectNode) json).put(fieldName, value);
    }
}