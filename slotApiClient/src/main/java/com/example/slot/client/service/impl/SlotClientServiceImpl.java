package com.example.slot.client.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.slot.client.consumer.SlotClientConsumer;
import com.example.slot.client.service.SlotClientService;

@Service
public class SlotClientServiceImpl implements SlotClientService {
	
	@Autowired
	SlotClientConsumer slotClientConsumer;

	@Override
	public Map<String, String> getSlotClient() {		
		return slotClientConsumer.getSlot();
	}

	@Override
	public Map<String, String> allocateSlotClient() {
		Map<String, String> sortedAvilableSlotMap = new TreeMap<String, String>();
		for (int number=1; number<21; number++) {
			slotClientConsumer.allocateSlot().forEach((k, v) -> sortedAvilableSlotMap.put(k, v));
		}
		return sortedAvilableSlotMap;
	}

}
