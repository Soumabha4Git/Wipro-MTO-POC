package com.example.slot.client.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.slot.client.service.SlotClientService;

@RestController
public class SlotClientController {
	
	@Autowired
	SlotClientService slotClientService;
	
	/*  Consumer Client */	
	@RequestMapping("/getMeSlotClient")
	public Map<String, String> getMeSlotClient() {
		return slotClientService.getSlotClient();
	}
	
	
	/*  Producer */
	@RequestMapping("/allocatedMeSlotClient")
	public Map<String, String> allocateSlotClient() {
		return slotClientService.allocateSlotClient();
	}

}
