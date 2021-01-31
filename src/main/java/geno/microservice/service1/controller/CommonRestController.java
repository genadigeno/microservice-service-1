package geno.microservice.service1.controller;

import geno.microservice.service1.service.Client2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class CommonRestController {

    @Value("${microservice.property}")
    private String microServiceProperty;

    @Autowired
    private Client2Service client2Service;

    @GetMapping(value = "/")
    public String common() {
        return "Service 1: " + microServiceProperty;
//        return "Service 1: ";
    }

    @GetMapping(value = "/service2")
    public String service2() {
        return client2Service.callService2();
    }
}
