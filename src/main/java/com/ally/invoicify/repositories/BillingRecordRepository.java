package com.ally.invoicify.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ally.invoicify.models.BillingRecord;

public interface BillingRecordRepository extends JpaRepository<BillingRecord, Long> {

	List<BillingRecord> findByIdIn(long[] recordIds);
	List<BillingRecord> findByClientId(Long id);
//
//	List<BillingRecord> findByClientIdAndLineItemIsNull(long clientId);

}
