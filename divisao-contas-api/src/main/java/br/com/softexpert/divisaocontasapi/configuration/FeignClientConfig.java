package br.com.softexpert.divisaocontasapi.configuration;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "br.com.softexpert.divisaocontasapi.controller.client")
public class FeignClientConfig {
}
