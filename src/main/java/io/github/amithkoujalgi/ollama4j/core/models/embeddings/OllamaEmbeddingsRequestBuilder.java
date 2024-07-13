package io.github.amithkoujalgi.ollama4j.core.models.embeddings;

import io.github.amithkoujalgi.ollama4j.core.utils.Options;

public class OllamaEmbeddingsRequestBuilder {

    private OllamaEmbeddingsRequestBuilder(String model, String prompt){
        request = new OllamaEmbeddingsRequestModel(model, prompt);
    }

    private OllamaEmbeddingsRequestModel request;

    public static OllamaEmbeddingsRequestBuilder getInstance(String model, String prompt){
        return new OllamaEmbeddingsRequestBuilder(model, prompt);
    }

    public OllamaEmbeddingsRequestModel build(){
        return request;
    }

    public OllamaEmbeddingsRequestBuilder withOptions(Options options){
        this.request.setOptions(options.getOptionsMap());
        return this;
    }

    public OllamaEmbeddingsRequestBuilder withKeepAlive(String keepAlive){
        this.request.setKeepAlive(keepAlive);
        return this;
    }

}
