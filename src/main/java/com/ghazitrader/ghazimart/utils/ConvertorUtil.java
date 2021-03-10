package com.ghazitrader.ghazimart.utils;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

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

    public static String listToJson(final List<Integer> productIds){
        try {
            return objectMapper.writeValueAsString(productIds);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static String otpRequest(String mobile, String message) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.createObjectNode();
        ((ObjectNode) rootNode).put("route", "v3");
        ((ObjectNode) rootNode).put("sender_id", "TXTIND");
        ((ObjectNode) rootNode).put("message_text", message);
        ((ObjectNode) rootNode).put("message", message);
        ((ObjectNode) rootNode).put("variables_values", "name");
        ((ObjectNode) rootNode).put("flash", 0);
        ((ObjectNode) rootNode).put("numbers", mobile);
        String jsonString = null;
        try {
            jsonString = mapper.writerWithDefaultPrettyPrinter()
                                   .writeValueAsString(rootNode);
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;

        }
        return jsonString;
    }
    

}
