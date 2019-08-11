package com.srimanjavagroup.sr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.srimanjavagroup.sr.dto.EChallan;

/**
 * 
 * @author sriman RTA Transport Service
 */
@Service
public class TransportService {
	public List<EChallan> getComplaints(String regNo) {
		List<EChallan> echallans = null;

		echallans = new ArrayList<EChallan>();
		echallans.add(new EChallan("c893", "2-wheeler", "2 Wheeler", 240));

		return echallans;
	}

}
