package com.ally.invoicify.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ally.invoicify.models.InvPerMonth;
import com.ally.invoicify.models.Invoice;
import com.ally.invoicify.repositories.InvoiceRepository;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    @Autowired
    private InvoiceRepository invoiceRepository;
    
    @GetMapping
    public InvPerMonth list() {
        InvPerMonth invXmonth = new InvPerMonth();

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
}