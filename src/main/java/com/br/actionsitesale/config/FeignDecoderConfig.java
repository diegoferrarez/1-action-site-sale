package com.br.actionsitesale.config;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Base64;

@Configuration
public class FeignDecoderConfig {
//
//    @Bean
//    public Base64.Decoder feignDecoder() {
//
//        ObjectFactory<HttpMessageConverters> messageConverters = () -> {
//            HttpMessageConverters converters = new HttpMessageConverters();
//            return converters;};
//        return new SpringDecoder(messageConverters);
//    }
}
