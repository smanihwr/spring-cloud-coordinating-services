package com.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class DashboardController {

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getTollRateFallBack")
	@GetMapping(value = "/dashboard")
	public String getTollRate(@RequestParam int stationId, Model m) {
		
//		RestTemplate rest = new RestTemplate();
//		TollRate tr = rest.getForObject("http://localhost:50110/tollrate/" + stationId, TollRate.class);

		TollRate tr = restTemplate.getForObject("http://toll-service/tollrate/" + stationId, TollRate.class);
		System.out.println("stationId: " + stationId);
		m.addAttribute("rate", tr.getCurrentRate());
		return "dashboard";
	}

	public String getTollRateFallBack(@RequestParam int stationId, Model m) {
        System.out.println("getTollRateFallBack called, " + stationId);
	    //setting default rate
	    m.addAttribute("rate", "1.00");

	    return "dashboard";
    }
}
