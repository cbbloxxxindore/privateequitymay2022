package com.vanguard.retail.privateequity.webservice.mock;

import java.time.LocalDateTime;

import com.vanguard.retail.privateequity.webservice.model.Investor;
import com.vanguard.retail.privateequity.webservice.model.InvestorRequest;

public class InvestorMock {

	public static InvestorRequest getInvestorRequest() {
		InvestorRequest investorRequest=new InvestorRequest();
		investorRequest.setInvestorLegalName("abhi");
		investorRequest.setInvestorShortName("vickey");
		investorRequest.setLimitedPartnerId("111");
		investorRequest.setParentInvestorId("111");
		investorRequest.setParentLongName("abhijeetsingh");
		
		return investorRequest;
	}

	 public static Investor	getInvestor(InvestorRequest investorRequest)
	{
		Investor investor= new Investor();
		investor.setInvestorId(12);
		investor.setEndDate(LocalDateTime.now());
		 investor.setInvestorLegalName(investorRequest.getInvestorLegalName());
		 investor.setInvestorShortName(investorRequest.getInvestorShortName());
		 investor.setInvestorStatus("Active");
		 investor.setLimitedPartnerId(investorRequest.getLimitedPartnerId());
		 investor.setParentInvestorId(investorRequest.getParentInvestorId());
		 investor.setVersionId("1212");
		 investor.setVbaAccountNumber("1212");
		 investor.setPoid("234");
		 investor.setParentLongName(investorRequest.getParentLongName());
		return investor;
	}
}
