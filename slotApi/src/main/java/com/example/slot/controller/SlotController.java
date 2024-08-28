package com.example.slot.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.slot.service.SlotService;

@RestController
public class SlotController {
	
	@Autowired
	SlotService slotService;

	/*  Consumer */
	@RequestMapping("/getMeSlot")
	public Map<String, String> getSlot() {
		return slotService.getSlot();
	}
	
	/*  Producer */
	@RequestMapping("/allocatedMeSlot")
	public HashMap<String, String> allocateSlot() {
		return slotService.allocateSlot();
	}
		
	
}
