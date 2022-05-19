package com.vanguard.retail.privateequity.webservice.resource;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vanguard.retail.privateequity.webservice.exception.PrivateEquityException;
import com.vanguard.retail.privateequity.webservice.model.InvestorRequest;
import com.vanguard.retail.privateequity.webservice.service.InvestorService;
@RestController
public class InvestorResource {
	
	public  static final String  CLASS_NAME= InvestorResource.class.getName()  ; 
	private static final Logger log = LoggerFactory.getLogger(InvestorResource.class);
	private static final String SAVE_METHOD = "createInvestor";
	private static final String EXCEPTION = " Exception occurred while saving Investor";

	@Autowired
	InvestorService investorService;
	@PostMapping("/investors")
	public  ResponseEntity<String > createInvestor(@Valid @RequestBody InvestorRequest investorRequest)
	{
			StringBuilder msgBuilder= new StringBuilder(CLASS_NAME).append("::"+SAVE_METHOD);
	try {
		 log.info(msgBuilder.append("Attemping to save investor  resource").toString());
	
		 investorService.SaveInvestor(investorRequest);
			log.info(msgBuilder.append("sucessfully  saved investor ").toString());
return ResponseEntity.ok("investor  has created");
	}
	catch (PrivateEquityException e) 
	{
		log.error(EXCEPTION+e);
		throw (new PrivateEquityException("something goes wrong"));
	}

}}
