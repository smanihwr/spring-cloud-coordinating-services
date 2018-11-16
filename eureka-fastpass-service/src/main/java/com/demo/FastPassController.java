package com.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@RestController
public class FastPassController {
	
	List<FastPassCustomer> customerlist = new ArrayList<FastPassCustomer>();
	
	public FastPassController() {
		
		FastPassCustomer fc1 = new FastPassCustomer(
		        "100", "Richard Seroter", "555-123-4567", new BigDecimal("19.50"));
		FastPassCustomer fc2 = new FastPassCustomer(
		        "101", "Jason Salmond", "555-321-7654", new BigDecimal("11.25"));
		FastPassCustomer fc3 = new FastPassCustomer(
		        "102", "Lisa Szpunar", "555-987-6543", new BigDecimal("35.00"));
		
		customerlist.add(fc1);
		customerlist.add(fc2);
		customerlist.add(fc3);
	}

    @GetMapping(value = "/fastpass")
    public FastPassCustomer getByFastPassId(@RequestParam(value = "fastpassid") String fastPassId) {

	    Predicate<FastPassCustomer> predicate = p -> p.getFastPassId().equals(fastPassId);
	    return customerlist.stream()
                .filter(predicate)
                .findFirst()
                .get();
    }

    @GetMapping(value = "/fastpassByPhone")
    public FastPassCustomer getByFastPassPhone(@RequestParam(value = "fastpassphone") String phone) {

	    Predicate<FastPassCustomer> predicate = p -> p.getFastPassPhone().equals(phone);
	    return customerlist.stream()
                .filter(predicate)
                .findFirst()
                .get();
    }

}
