package com.nt.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingServiceComponent {
	
	@Autowired
	private DiscoveryClient client;
	
	public String getBillingInfo() {
		List<ServiceInstance> listSI = client.getInstances("BillingService");
		ServiceInstance si = listSI.get(0);
		String url = si.getUri() + "/billing/info";
		RestTemplate template = new RestTemplate();
		String response = template.getForObject(url,String.class);
		return response;
	}

}
