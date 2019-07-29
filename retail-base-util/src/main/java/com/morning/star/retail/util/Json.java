package com.morning.star.retail.util;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Json Util.
 *
 * @author Tim
 */
public class Json {
    private static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(Include.NON_NULL);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    public static <T> T fromJson(String json, Class<T> cls) {
        return mapper.convertValue(toJsonNode(json), cls);
    }

    public static <T> T fromJson(String json, TypeReference<T> type) {
        return mapper.convertValue(toJsonNode(json), type);
    }

    public static <T> T from(Object value, Class<T> cls) {

        return mapper.convertValue(value, cls);
    }

    public static <T> T readVal(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException("error while json read value", e);
        }
    }

    public static <T> T from(JsonNode json, Class<T> cls) {
        return mapper.convertValue(json, cls);
    }

    public static <T> T from(JsonNode json, TypeReference<T> type) {
        return mapper.convertValue(json, type);
    }

    public static JsonNode toJsonNode(String content) {
        try {
            return mapper.readTree(content);
        } catch (IOException e) {
        }
        return null;
    }

    public static String toJson(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
