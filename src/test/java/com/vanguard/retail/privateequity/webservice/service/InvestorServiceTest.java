package com.vanguard.retail.privateequity.webservice.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.junit.JUnitTestRule;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vanguard.retail.privateequity.webservice.dao.InvestorRepository;
import com.vanguard.retail.privateequity.webservice.exception.PrivateEquityException;
import com.vanguard.retail.privateequity.webservice.mock.InvestorMock;
import com.vanguard.retail.privateequity.webservice.model.Investor;
import com.vanguard.retail.privateequity.webservice.model.InvestorRequest;
@RunWith(SpringRunner.class)
@SpringBootTest
@Category(JUnitTestRule.class)
public class InvestorServiceTest {
	@Mock
	InvestorRepository investorRepositrory;
	@InjectMocks
	InvestorServiceImpl investorServiceImpl;
 @Test
	public void saveInvestorSucess()
 {
	InvestorRequest investorRequest =InvestorMock.getInvestorRequest();
	Investor investor1= InvestorMock. getInvestor(investorRequest);

	when(investorRepositrory.save(any())).thenReturn(investor1);
	 investorServiceImpl.SaveInvestor(investorRequest);
 }

 @Test(expected = PrivateEquityException.class)
	public void saveInvestorFailure()
{
	InvestorRequest investorRequest =InvestorMock.getInvestorRequest();
	Investor investor1= InvestorMock. getInvestor(investorRequest);

	when(investorRepositrory.save(any())).thenThrow(PrivateEquityException.class);
	 investorServiceImpl.SaveInvestor(investorRequest);
}
}
