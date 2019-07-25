package com.ally.invoicify.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;

import com.ally.invoicify.models.InvPerMonth;
import com.ally.invoicify.models.Invoice;
import com.ally.invoicify.repositories.InvoiceRepository;
import com.ally.invoicify.repositories.CompanyRepository;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
	CompanyRepository companyRepo;
    
    @GetMapping
    public InvPerMonth list() {
        InvPerMonth invXmonth = new InvPerMonth();

        // Loop through invoices, add to month counters
        for (Invoice invoice : invoiceRepository.findAll()) {
            switch (invoice.getCreatedOn().getMonth()) {
                case 0:
                    invXmonth.setJan(invXmonth.getJan() + 1);
                    break;
                case 1:
                    invXmonth.setFeb(invXmonth.getFeb() + 1);
                    break;
                case 2:
                    invXmonth.setMar(invXmonth.getMar() + 1);
                    break;
                case 3:
                    invXmonth.setApr(invXmonth.getApr() + 1);
                    break;
                case 4:
                    invXmonth.setMay(invXmonth.getMay() + 1);
                    break;
                case 5:
                    invXmonth.setJun(invXmonth.getJun() + 1);
                    break;
                case 6:
                    invXmonth.setJul(invXmonth.getJul() + 1);
                    break;
                case 7:
                    invXmonth.setAug(invXmonth.getAug() + 1);
                    break;
                case 8:
                    invXmonth.setSep(invXmonth.getSep() + 1);
                    break;
                case 9:
                    invXmonth.setOct(invXmonth.getOct() + 1);
                    break;
                case 10:
                    invXmonth.setNov(invXmonth.getNov() + 1);
                    break;
                case 11:
                    invXmonth.setDec(invXmonth.getDec() + 1);
                    break;
                default:
                    break;
            }
        }

        return invXmonth;
    }

    @GetMapping("/client/{clientId}")
    public InvPerMonth listClient(@PathVariable long clientId) {
        InvPerMonth invXmonth = new InvPerMonth();
        List<Invoice> clientInvoices = new ArrayList<Invoice>();

        // Look at all invoices, if clientId matches add it to clientInvoices
        for (Invoice invoice : invoiceRepository.findAll()) {
            if (invoice.getCompany().getId() == clientId) {
                clientInvoices.add(invoice);
            }
        }

        // Loop through invoices, add to month counters
        for (Invoice invoice : clientInvoices) {
            switch (invoice.getCreatedOn().getMonth()) {
                case 0:
                    invXmonth.setJan(invXmonth.getJan() + 1);
                    break;
                case 1:
                    invXmonth.setFeb(invXmonth.getFeb() + 1);
                    break;
                case 2:
                    invXmonth.setMar(invXmonth.getMar() + 1);
                    break;
                case 3:
                    invXmonth.setApr(invXmonth.getApr() + 1);
                    break;
                case 4:
                    invXmonth.setMay(invXmonth.getMay() + 1);
                    break;
                case 5:
                    invXmonth.setJun(invXmonth.getJun() + 1);
                    break;
                case 6:
                    invXmonth.setJul(invXmonth.getJul() + 1);
                    break;
                case 7:
                    invXmonth.setAug(invXmonth.getAug() + 1);
                    break;
                case 8:
                    invXmonth.setSep(invXmonth.getSep() + 1);
                    break;
                case 9:
                    invXmonth.setOct(invXmonth.getOct() + 1);
                    break;
                case 10:
                    invXmonth.setNov(invXmonth.getNov() + 1);
                    break;
                case 11:
                    invXmonth.setDec(invXmonth.getDec() + 1);
                    break;
                default:
                    break;
            }
        }

        return invXmonth;
    }
}