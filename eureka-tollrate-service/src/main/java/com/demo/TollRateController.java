package com.demo;

import java.math.BigDecimal;
import java.time.Instant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TollRateController {
	
	@GetMapping(value = "/tollrate/{stationId}")
	public TollRate GetTollRate(@PathVariable int stationId) {

		System.out.println("Station id" + stationId);
		
		TollRate tr;
		
		switch(stationId) {
		case 1:
			tr = new TollRate(stationId, new BigDecimal("0.55"), Instant.now().toString());
			break;
		case 2:
			tr = new TollRate(stationId, new BigDecimal("1.05"), Instant.now().toString());
			break;
		case 3:
			tr = new TollRate(stationId, new BigDecimal("0.60"), Instant.now().toString());
			break;
		default:
			tr = new TollRate(stationId, new BigDecimal("1.00"), Instant.now().toString());
			break;
		}
		
		return tr;
	}
}