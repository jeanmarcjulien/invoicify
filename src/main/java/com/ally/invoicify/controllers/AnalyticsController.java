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
    public List<InvPerMonth> list() {
        List<InvPerMonth> invXmonthList = new ArrayList<InvPerMonth>();
        InvPerMonth jan = new InvPerMonth("jan", 0);
        InvPerMonth feb = new InvPerMonth("feb", 0);
        InvPerMonth mar = new InvPerMonth("mar", 0);
        InvPerMonth apr = new InvPerMonth("apr", 0);
        InvPerMonth may = new InvPerMonth("may", 0);
        InvPerMonth jun = new InvPerMonth("jun", 0);
        InvPerMonth jul = new InvPerMonth("jul", 0);
        InvPerMonth aug = new InvPerMonth("aug", 0);
        InvPerMonth sep = new InvPerMonth("sep", 0);
        InvPerMonth oct = new InvPerMonth("oct", 0);
        InvPerMonth nov = new InvPerMonth("nov", 0);
        InvPerMonth dec = new InvPerMonth("dec", 0);

        // Loop through invoices, set new value for months
        for (Invoice invoice : invoiceRepository.findAll()) {
            switch (invoice.getCreatedOn().getMonth()) {
                case 0:
                    jan.setValue(jan.getValue() + 1);
                    break;
                case 1:
                    feb.setValue(feb.getValue() + 1);
                    break;
                case 2:
                    mar.setValue(mar.getValue() + 1);
                    break;
                case 3:
                    apr.setValue(apr.getValue() + 1);
                    break;
                case 4:
                    may.setValue(may.getValue() + 1);
                    break;
                case 5:
                    jun.setValue(jun.getValue() + 1);
                    break;
                case 6:
                    jul.setValue(jul.getValue() + 1);
                    break;
                case 7:
                    aug.setValue(aug.getValue() + 1);
                    break;
                case 8:
                    sep.setValue(sep.getValue() + 1);
                    break;
                case 9:
                    oct.setValue(oct.getValue() + 1);
                    break;
                case 10:
                    nov.setValue(nov.getValue() + 1);
                    break;
                case 11:
                    dec.setValue(dec.getValue() + 1);
                    break;
                default:
                    break;
            }
        }

        invXmonthList.add(jan);
        invXmonthList.add(feb);
        invXmonthList.add(mar);
        invXmonthList.add(apr);
        invXmonthList.add(may);
        invXmonthList.add(jun);
        invXmonthList.add(jul);
        invXmonthList.add(aug);
        invXmonthList.add(sep);
        invXmonthList.add(oct);
        invXmonthList.add(nov);
        invXmonthList.add(dec);

        return invXmonthList;
    }

    @GetMapping("/client/{clientId}")
    public List<InvPerMonth> listClient(@PathVariable long clientId) {
        List<InvPerMonth> invXmonthList = new ArrayList<InvPerMonth>();
        List<Invoice> clientInvoices = new ArrayList<Invoice>();
        InvPerMonth jan = new InvPerMonth("jan", 0);
        InvPerMonth feb = new InvPerMonth("feb", 0);
        InvPerMonth mar = new InvPerMonth("mar", 0);
        InvPerMonth apr = new InvPerMonth("apr", 0);
        InvPerMonth may = new InvPerMonth("may", 0);
        InvPerMonth jun = new InvPerMonth("jun", 0);
        InvPerMonth jul = new InvPerMonth("jul", 0);
        InvPerMonth aug = new InvPerMonth("aug", 0);
        InvPerMonth sep = new InvPerMonth("sep", 0);
        InvPerMonth oct = new InvPerMonth("oct", 0);
        InvPerMonth nov = new InvPerMonth("nov", 0);
        InvPerMonth dec = new InvPerMonth("dec", 0);

        // Look at all invoices, if clientId matches add it to clientInvoices
        for (Invoice invoice : invoiceRepository.findAll()) {
            if (invoice.getCompany().getId() == clientId) {
                clientInvoices.add(invoice);
            }
        }

        // Loop through invoices, set new value for months
        for (Invoice invoice : clientInvoices) {
            switch (invoice.getCreatedOn().getMonth()) {
                case 0:
                    jan.setValue(jan.getValue() + 1);
                    break;
                case 1:
                    feb.setValue(feb.getValue() + 1);
                    break;
                case 2:
                    mar.setValue(mar.getValue() + 1);
                    break;
                case 3:
                    apr.setValue(apr.getValue() + 1);
                    break;
                case 4:
                    may.setValue(may.getValue() + 1);
                    break;
                case 5:
                    jun.setValue(jun.getValue() + 1);
                    break;
                case 6:
                    jul.setValue(jul.getValue() + 1);
                    break;
                case 7:
                    aug.setValue(aug.getValue() + 1);
                    break;
                case 8:
                    sep.setValue(sep.getValue() + 1);
                    break;
                case 9:
                    oct.setValue(oct.getValue() + 1);
                    break;
                case 10:
                    nov.setValue(nov.getValue() + 1);
                    break;
                case 11:
                    dec.setValue(dec.getValue() + 1);
                    break;
                default:
                    break;
            }
        }

        invXmonthList.add(jan);
        invXmonthList.add(feb);
        invXmonthList.add(mar);
        invXmonthList.add(apr);
        invXmonthList.add(may);
        invXmonthList.add(jun);
        invXmonthList.add(jul);
        invXmonthList.add(aug);
        invXmonthList.add(sep);
        invXmonthList.add(oct);
        invXmonthList.add(nov);
        invXmonthList.add(dec);

        return invXmonthList;
    }

    @GetMapping("/user/{userId}/graph")
    public List<InvPerMonth> listGraph(@PathVariable long userId) {
        List<Invoice> userInvoices = new ArrayList<Invoice>();
        List<InvPerMonth> invXmonthList = new ArrayList<InvPerMonth>();
        InvPerMonth jan = new InvPerMonth("jan", 0);
        InvPerMonth feb = new InvPerMonth("feb", 0);
        InvPerMonth mar = new InvPerMonth("mar", 0);
        InvPerMonth apr = new InvPerMonth("apr", 0);
        InvPerMonth may = new InvPerMonth("may", 0);
        InvPerMonth jun = new InvPerMonth("jun", 0);
        InvPerMonth jul = new InvPerMonth("jul", 0);
        InvPerMonth aug = new InvPerMonth("aug", 0);
        InvPerMonth sep = new InvPerMonth("sep", 0);
        InvPerMonth oct = new InvPerMonth("oct", 0);
        InvPerMonth nov = new InvPerMonth("nov", 0);
        InvPerMonth dec = new InvPerMonth("dec", 0);

        // Look at all invoices, if userId matches add it to userInvoices
        for (Invoice invoice : invoiceRepository.findAll()) {
            if (invoice.getCreatedBy().getId() == userId) {
                userInvoices.add(invoice);
            }
        }

        // Loop through invoices, set new value for months
        for (Invoice invoice : userInvoices) {
            switch (invoice.getCreatedOn().getMonth()) {
                case 0:
                    jan.setValue(jan.getValue() + 1);
                    break;
                case 1:
                    feb.setValue(feb.getValue() + 1);
                    break;
                case 2:
                    mar.setValue(mar.getValue() + 1);
                    break;
                case 3:
                    apr.setValue(apr.getValue() + 1);
                    break;
                case 4:
                    may.setValue(may.getValue() + 1);
                    break;
                case 5:
                    jun.setValue(jun.getValue() + 1);
                    break;
                case 6:
                    jul.setValue(jul.getValue() + 1);
                    break;
                case 7:
                    aug.setValue(aug.getValue() + 1);
                    break;
                case 8:
                    sep.setValue(sep.getValue() + 1);
                    break;
                case 9:
                    oct.setValue(oct.getValue() + 1);
                    break;
                case 10:
                    nov.setValue(nov.getValue() + 1);
                    break;
                case 11:
                    dec.setValue(dec.getValue() + 1);
                    break;
                default:
                    break;
            }
        }
        invXmonthList.add(jan);
        invXmonthList.add(feb);
        invXmonthList.add(mar);
        invXmonthList.add(apr);
        invXmonthList.add(may);
        invXmonthList.add(jun);
        invXmonthList.add(jul);
        invXmonthList.add(aug);
        invXmonthList.add(sep);
        invXmonthList.add(oct);
        invXmonthList.add(nov);
        invXmonthList.add(dec);

        return invXmonthList;
    }
}