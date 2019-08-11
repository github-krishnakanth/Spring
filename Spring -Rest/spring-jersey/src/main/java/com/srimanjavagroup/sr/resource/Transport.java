package com.srimanjavagroup.sr.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.srimanjavagroup.sr.dto.EChallan;
import com.srimanjavagroup.sr.service.TransportService;

@Component
@Path("/transport")
public class Transport {
	@Autowired
	protected TransportService transportService;

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/complaints/{regNo}")
	public List<EChallan> getComplaints(@PathParam("regNo") String regNo) {
		List<EChallan> eChallans = null;

		eChallans = transportService.getComplaints(regNo);
		return eChallans;
	}
}
