package com.ally.invoicify.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ally.invoicify.models.BillingRecord;
import com.ally.invoicify.repositories.BillingRecordRepository;
import com.ally.invoicify.repositories.CompanyRepository;

@RestController
@RequestMapping("/api/billing-record")
public class BillingRecordController {

	private BillingRecordRepository recordRepository;

	public BillingRecordController(BillingRecordRepository recordRepository, CompanyRepository companyRepository) {
		this.recordRepository = recordRepository;
	}

	@GetMapping("/{id}")
	public List<BillingRecord> listById(@PathVariable long id) {
		// return "hi";
		return recordRepository.findByClientId(id);
	}

	@GetMapping
	public List<BillingRecord> list() {
		return recordRepository.findAll();
	}



}