package com.ghazitrader.ghazimart.utils;

import java.text.DecimalFormat;
import java.util.Random;

import com.ghazitrader.ghazimart.model.StandardResponse;

public class CommanUtil {

    public static StandardResponse getResponse(final String data) {

        final StandardResponse response = new StandardResponse();
        if (null != data) {
            response.setData(data);
            response.setDescription("Successfully");
            response.setStatusCode(200);
        } else {
            response.setDescription("Record Not found");
            response.setStatusCode(30);
        }

        return response;

    }

    public static boolean isNotEmptyOrNotNull(final String value) {
        if (null != value && !value.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isTokenValid(final String value) {
        if (isNotEmptyOrNotNull(value) && value.equals("jnbvfdssaaaa656767ASGHFHHHH$**()<>{}")) {
            return true;
        } else {
            return false;
        }
    }

    public static StandardResponse errorResponse(final String description) {
        final StandardResponse response = new StandardResponse();
        response.setDescription(description);
        response.setStatusCode(30);
        return response;
    }

    public static String generateOTP(){

        String otp= new DecimalFormat("000000").format(new Random().nextInt(999999));

        return otp;

    }
   
}
