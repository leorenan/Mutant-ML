package com.mercadolibre.xmen.validate.mutant.detectmutant;



import org.junit.Ignore;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

@Ignore
public class TestContext implements Context {

    private String awsRequestId;
    private ClientContext clientContext;
    private String functionName;
    private CognitoIdentity identity;
    private String logGroupName;
    private String logStreamName;
    private LambdaLogger logger;
    private int memoryLimitInMB;
    private int remainingTimeInMillis;
    private String functionVersion;
    private String invokedFunctionArn;

    public TestContext() {
    	setAwsRequestId("dsa85-518bvcf-fdsytr");
    	setClientContext(null);   
    	setFunctionName("handleRequest");
    	setIdentity(null);
    	setLogGroupName("meli");
    	setLogStreamName("MutantMercadolibre");
    	setLogger(new TestLogger());
    	setMemoryLimitInMB(128);
    	setRemainingTimeInMillis(15000);
    	setFunctionVersion("1.0");
    	setInvokedFunctionArn("LambdaFunctionHandler");
    }
    
    @Override
    public String getAwsRequestId() {
        return awsRequestId;
    }

    public void setAwsRequestId(String value) {
        awsRequestId = value;
    }

    @Override
    public ClientContext getClientContext() {
        return clientContext;
    }

    public void setClientContext(ClientContext value) {
        clientContext = value;
    }

    @Override
    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String value) {
        functionName = value;
    }

    @Override
    public CognitoIdentity getIdentity() {
        return identity;
    }

    public void setIdentity(CognitoIdentity value) {
        identity = value;
    }

    @Override
    public String getLogGroupName() {
        return logGroupName;
    }

    public void setLogGroupName(String value) {
        logGroupName = value;
    }

    @Override
    public String getLogStreamName() {
        return logStreamName;
    }

    public void setLogStreamName(String value) {
        logStreamName = value;
    }

    @Override
    public LambdaLogger getLogger() {
        return logger;
    }

    public void setLogger(LambdaLogger value) {
        logger = value;
    }

    @Override
    public int getMemoryLimitInMB() {
        return memoryLimitInMB;
    }

    public void setMemoryLimitInMB(int value) {
        memoryLimitInMB = value;
    }

    @Override
    public int getRemainingTimeInMillis() {
        return remainingTimeInMillis;
    }

    public void setRemainingTimeInMillis(int value) {
        remainingTimeInMillis = value;
    }

    @Override
    public String getFunctionVersion() {
        return functionVersion;
    }

    public void setFunctionVersion(String value) {
        functionVersion = value;
    }

    @Override
    public String getInvokedFunctionArn() {
        return invokedFunctionArn;
    }

    public void setInvokedFunctionArn(String value) {
        invokedFunctionArn = value;
    }

    private static class TestLogger implements LambdaLogger {

        @Override
        public void log(String message) {
            System.err.println(message);
        }
    }
}
