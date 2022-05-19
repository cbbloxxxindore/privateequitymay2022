package com.vanguard.retail.privateequity.webservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vanguard.retail.privateequity.webservice.model.Investor;
@Repository
public interface InvestorRepository extends JpaRepository<Investor, Integer> {

}
