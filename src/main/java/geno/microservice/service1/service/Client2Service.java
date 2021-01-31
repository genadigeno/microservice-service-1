package geno.microservice.service1.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("client2Service")
public class Client2Service {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "failureCallingService2")
    public String callService2(){
        return restTemplate.getForObject("http://service-2/", String.class);
    }

    public String failureCallingService2(){
        return "Service 2 is unavailable";
    }
}
