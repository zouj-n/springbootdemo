package com.june.springbootdemo.utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class JsonParserUtil {

    private static ObjectMapper objectMapper= new ObjectMapper();

	static {
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true);
		objectMapper.setSerializationInclusion(Include.NON_NULL);
	}

    public static <T> T entity(String json, Class<T> tClass) throws IOException {
        return objectMapper.readValue(json, tClass);
    }

    public static <T> ArrayList<T> arrayList(String json, Class<T> tClass) throws IOException {
        TypeFactory typeFactory = objectMapper.getTypeFactory();
        JavaType type = typeFactory.constructCollectionType(ArrayList.class, tClass);
        return objectMapper.readValue(json, type);
    }

    public static String toJson(Object object) throws IOException {
        return objectMapper.writeValueAsString(object);
    }

    public static Map<String, Object> toMap(String json) throws IOException {
    	return objectMapper.readValue(json, new TypeReference<Map<String,Object>>(){});
    }

}
