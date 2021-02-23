package com.ghazitrader.ghazimart.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertorUtil {
    public static ObjectMapper objectMapper = new ObjectMapper();

    public static String convertObjectToString(final Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public static <T> T convertStringToObject(final String jsonString, final Class<T> genericObject) {
        try {
            if (CommanUtil.isNotEmptyOrNotNull(jsonString)) {
                return (T) objectMapper.readValue(jsonString, genericObject);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static String getJsonValue(final String data, final String key) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode content;
        try {
            content = mapper.readValue(data, JsonNode.class);
            return content.get(key).asText();

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static int stringToInt(final String value){
       return Integer.parseInt(value);
    }

}
