package com.example.slot.client.consumer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="SLOTAPI")
public interface SlotClientConsumer {
	
	@RequestMapping("/getMeSlot")
	public Map<String, String> getSlot();
	
	@RequestMapping("/allocatedMeSlot")
	public Map<String, String> allocateSlot();

}
