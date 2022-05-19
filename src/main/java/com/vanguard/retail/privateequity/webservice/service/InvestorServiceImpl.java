package com.vanguard.retail.privateequity.webservice.service;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanguard.retail.privateequity.webservice.dao.InvestorRepository;
import com.vanguard.retail.privateequity.webservice.exception.PrivateEquityException;
import com.vanguard.retail.privateequity.webservice.model.Investor;
import com.vanguard.retail.privateequity.webservice.model.InvestorRequest;
@Service
public class InvestorServiceImpl implements InvestorService {
	public  static final String  CLASS_NAME= InvestorServiceImpl.class.getName()  ; 
	private static final Logger log = LoggerFactory.getLogger(InvestorServiceImpl.class);
	private static final String SAVE_METHOD = "saveInvestor            ";
	private static final String EXCEPTION = " Exception occurred while saving Investor";
@Autowired
	InvestorRepository investorRepository;
	public void SaveInvestor(InvestorRequest investorRequest) {
		StringBuilder msgBuilder= new StringBuilder(CLASS_NAME).append("::"+SAVE_METHOD);
		try {
			 log.info(msgBuilder.append("Attemping to save investor  service").toString());
		
			Investor investor =getInvestor(investorRequest);
			investorRepository.save(investor);
			log.info(msgBuilder.append("sucessfully  saved investor ").toString());

		} catch (PrivateEquityException e) {
			log.error(EXCEPTION+e);

			throw(new PrivateEquityException("something is going wrong") );
		
		}
		
	}
	
	
	Investor	getInvestor(InvestorRequest investorRequest)
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
