package com.don.handler;

import java.util.List;

import com.dns.beans.LoanEnquiry;
import com.dns.beans.LoanInfo;
import com.dns.beans.LoanParameters;
import com.dns.helper.Cache;

public class LoanEnquiryHandler {
	private Cache cache;

	public final void setCache(Cache cache) {
		this.cache = cache;
	}

	public LoanInfo enquire(LoanEnquiry loanEnquiry) throws Exception {
		float interestRate = 0.0f;
		float interestAmount = 0.0f;
		float repaymentAmount = 0.0f;
		float emi = 0.0f;
		LoanInfo loanInfo = null;
		
		List<LoanParameters> loanParameters = null;
		LoanParameters loanParameter = null;
		
		if(cache.containsKey(loanEnquiry.getLoanType()) == false) {
			throw new Exception("No data found in cache");
		}
		
		loanParameters = (List<LoanParameters>) cache.get(loanEnquiry.getLoanType());
		
		for(LoanParameters lp : loanParameters) {
			if((loanEnquiry.getPrinciple() >= lp.getMinPrincipleAmount() && loanEnquiry.getPrinciple() <= lp.getMaxPrincipleAmount() &&
					loanEnquiry.getTenure() >= lp.getMinTenure() && loanEnquiry.getTenure() <= lp.getMaxTenure() && 
					(loanEnquiry.getPlace()).equals(lp.getPlace()))) {
				loanParameter = lp;
				break;
			}
		}
		if(loanParameter == null) {
			throw new Exception("No matching loan found for your loan enquiry");
		}
		
		interestRate = loanParameter.getInterestRate();
		interestAmount = (loanEnquiry.getPrinciple() * loanEnquiry.getTenure() * interestRate)/100;
		repaymentAmount = loanEnquiry.getPrinciple() + interestAmount;
		emi = repaymentAmount / loanEnquiry.getTenure();
		
		loanInfo = new LoanInfo();
		loanInfo.setLoanType(loanEnquiry.getLoanType());
		loanInfo.setPrinciple(loanEnquiry.getPrinciple());
		loanInfo.setInterestRate(interestRate);
		loanInfo.setInterestAmount(interestAmount);
		loanInfo.setRepaymentAmount(repaymentAmount);
		loanInfo.setTenure(loanEnquiry.getTenure());
		loanInfo.setEmi(emi);
		
		return loanInfo;
	}
}
 