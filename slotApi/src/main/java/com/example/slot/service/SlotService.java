package com.example.slot.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;



@Service
public interface SlotService {
	
	public Map<String, String> getSlot() ;
	
	public HashMap<String, String> allocateSlot();

}
