package com.example.demo.config;

import com.example.demo.exception.PostNotFoundException;
import com.example.demo.exception.ServiceUnavailableException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignErrorDecoder {

    @Bean
    public ErrorDecoder errorDecoder() {

        return new ErrorDecoder() {

            @Override
            public Exception decode(String methodKey, Response response) {

                if (response.status() == 404) {
                    return new PostNotFoundException(
                            "post not found"
                    );
                }

                if (response.status() == 500) {
                    return new ServiceUnavailableException(
                            "Post service is unavailable"
                    );
                }

                return new ErrorDecoder.Default().decode(methodKey, response);
            }
        };
    }
}