package com.srimanjavagroup.sr.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "e-challan")
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class EChallan {
	@XmlElement(name = "challan-no")
	protected String challanNo;
	@XmlElement(name = "complaint-type")
	protected String complaintType;
	protected String description;
	protected float amount;

	public EChallan() {
	}

	public EChallan(String challanNo, String complaintType, String description, float amount) {
		this.challanNo = challanNo;
		this.complaintType = complaintType;
		this.description = description;
		this.amount = amount;
	}

	public String getChallanNo() {
		return challanNo;
	}

	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
	}

	public String getComplaintType() {
		return complaintType;
	}

	public void setComplaintType(String complaintType) {
		this.complaintType = complaintType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

}
