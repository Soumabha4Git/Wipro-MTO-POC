package com.example.slot.client.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;


@Service
public interface SlotClientService {
	
	public Map<String, String> getSlotClient() ;	
	public Map<String, String> allocateSlotClient();

}
