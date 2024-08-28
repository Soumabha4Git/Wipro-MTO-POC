package com.example.slot.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.example.slot.service.SlotService;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;


@Service
public class SlotServiceImpl implements SlotService {
	
	// HashMap<String, String> slotMap = new HashMap<>();
	
	// Create a cache with a time-based eviction policy
    Cache<String, String> slotCache = CacheBuilder.newBuilder()
            .expireAfterWrite(5, TimeUnit.MINUTES)  // Set the expiration time
            .build();

	@Override
	public Map<String, String> getSlot() {		
		
		if (slotCache.asMap().isEmpty()) {
			for (int number=1; number<10; number++) {
				// slotMap.put("Slot - "+String.valueOf(number)+ " -", "UnAllocated");
				slotCache.put("Slot-"+String.valueOf(number), "UnAllocated");
			}
			int number = 10;
			for (char alphabet = 'A'; alphabet <='Z'; ++alphabet) {
			      number = number + 1;
			       // slotMap.put("Slot - "+String.valueOf(alphabet)+ " -", "UnAllocated");
			       slotCache.put("Slot-"+String.valueOf(alphabet), "UnAllocated");
			}
		} 	
			
		// Map<String, String> sortedSlotMap = new TreeMap<String, String>(slotMap) ;
		Map<String, String> sortedSlotMap = new TreeMap<String, String>(slotCache.asMap()) ;		
		
		return sortedSlotMap;
	}

	@Override
	public HashMap<String, String> allocateSlot() {	
		Map<String, String> sortedSlotMap = getSlot();
		Map<String, String> sortedAvilableSlotMap = new TreeMap<String, String>();
		HashMap<String, String> allocatedMeSlotMap = new HashMap<>();
		
		for (Map.Entry<String, String> slotMap : sortedSlotMap.entrySet()) {
		    if(slotMap.getValue().equals("UnAllocated") ){
		    	sortedAvilableSlotMap.put(slotMap.getKey(), slotMap.getValue());
		    }
		}
		
		Map.Entry<String,String> allocatedSlotMap = null;
		
		if (sortedAvilableSlotMap.entrySet().iterator().hasNext()) {
			allocatedSlotMap = sortedAvilableSlotMap.entrySet().iterator().next();
			String allocatedMeSlotKey = allocatedSlotMap.getKey();			
			// Get the current date and time
			LocalDateTime now = LocalDateTime.now();
			// Define the format
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			// Format the current date and time
			String formattedNow = now.format(formatter);	
			String allocatedMeSlotValue = formattedNow;
			slotCache.put(allocatedMeSlotKey, formattedNow);
			System.out.println("Time before Release :- " + now);		
			System.out.println(allocatedMeSlotKey+" :- " + slotCache.getIfPresent(allocatedMeSlotKey));		
			// slotCache.put(allocatedMeSlotKey, "UnAllocated");
			System.out.println("Time after Release :- " + now);
			allocatedMeSlotMap.put(allocatedMeSlotKey, allocatedMeSlotValue);	
		}
			
		
			
		return  allocatedMeSlotMap;
	}

}
