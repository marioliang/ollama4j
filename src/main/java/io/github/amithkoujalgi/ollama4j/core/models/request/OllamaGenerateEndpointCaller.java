package io.github.amithkoujalgi.ollama4j.core.models.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.github.amithkoujalgi.ollama4j.core.models.BasicAuth;
import io.github.amithkoujalgi.ollama4j.core.models.OllamaResponseModel;
import io.github.amithkoujalgi.ollama4j.core.utils.Utils;

public class OllamaGenerateEndpointCaller extends OllamaEndpointCaller{

    private static final Logger LOG = LoggerFactory.getLogger(OllamaGenerateEndpointCaller.class);

    public OllamaGenerateEndpointCaller(String host, BasicAuth basicAuth, long requestTimeoutSeconds, boolean verbose) {
        super(host, basicAuth, requestTimeoutSeconds, verbose);   
    }

    @Override
    protected String getEndpointSuffix() {
        return "/api/generate";
    }

    @Override
    protected boolean parseResponseAndAddToBuffer(String line, StringBuilder responseBuffer) {
                try {
                    OllamaResponseModel ollamaResponseModel = Utils.getObjectMapper().readValue(line, OllamaResponseModel.class);
                    responseBuffer.append(ollamaResponseModel.getResponse());
                    return ollamaResponseModel.isDone();
                } catch (JsonProcessingException e) {
                    LOG.error("Error parsing the Ollama chat response!",e);
                    return true;
                }         
    }

    
    
    
}
