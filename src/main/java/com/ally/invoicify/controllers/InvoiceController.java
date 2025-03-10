package com.ally.invoicify.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ally.invoicify.models.BillingRecord;
import com.ally.invoicify.models.Invoice;
import com.ally.invoicify.models.InvoiceLineItem;
import com.ally.invoicify.models.InvoiceView;
import com.ally.invoicify.models.User;
import com.ally.invoicify.repositories.BillingRecordRepository;
import com.ally.invoicify.repositories.CompanyRepository;
import com.ally.invoicify.repositories.InvoiceRepository;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {

	@Autowired
	private BillingRecordRepository recordRepository;

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private CompanyRepository companyRepository;

	@PostMapping("{clientId}")
	public Invoice createInvoice(@RequestBody InvoiceView invoiceView, @PathVariable long clientId, Authentication auth) {
		User creator = (User) auth.getPrincipal();
		List<BillingRecord> records = recordRepository.findByIdIn(invoiceView.getRecordIds());
		Random random = new Random();
		int year = random.nextInt(2019 - 2015 + 1) + 2015;
		int dayOfYear = random.nextInt(365 - 1 + 1) + 1;;
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);
		Date now = new Date(calendar.getTimeInMillis());
		Invoice invoice = new Invoice();
		invoice.setInvoiceDescription(invoiceView.getInvoiceDescription());

		List<InvoiceLineItem> items = new ArrayList<InvoiceLineItem>();
		for (BillingRecord record : records) {
			InvoiceLineItem lineItem = new InvoiceLineItem();
			record.setInUse(true);
			lineItem.setBillingRecord(record);
			lineItem.setCreatedBy(creator);
			lineItem.setCreatedOn(now);
			lineItem.setInvoice(invoice);
			items.add(lineItem);
		}

		invoice.setLineItems(items);
		invoice.setCreatedBy(creator);
		invoice.setCreatedOn(now);
		invoice.setCompany(companyRepository.findOne(clientId));

		recordRepository.save(records);
		return invoiceRepository.save(invoice);
	}


	@GetMapping
	public List<Invoice> list() {
		return invoiceRepository.findAll();
	}

}


















