package com.mercadolibre.xmen.validate.mutant.detectmutant.model;

import java.util.Map;

public class ApiGatewayProxyResponse {
    private int statusCode;
    private Map<String, String> headers;
    private String body;
    private boolean isBase64Encoded;

    public int getStatusCode() {
        return statusCode;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    public boolean getIsBase64Encoded() {
        return isBase64Encoded;
    }

    public ApiGatewayProxyResponse(int statusCode, Map<String, String> headers, String body, boolean isBase64Encoded) {
        this.statusCode = statusCode;
        this.headers = headers;
        this.body = body;
        this.isBase64Encoded = isBase64Encoded;
    }

    

}