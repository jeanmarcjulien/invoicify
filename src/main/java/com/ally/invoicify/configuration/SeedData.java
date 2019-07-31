package com.ally.invoicify.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ally.invoicify.models.Company;
import com.ally.invoicify.models.FlatFeeBillingRecord;
import com.ally.invoicify.models.RateBasedBillingRecord;
import com.ally.invoicify.models.User;
import com.ally.invoicify.repositories.BillingRecordRepository;
import com.ally.invoicify.repositories.CompanyRepository;
import com.ally.invoicify.repositories.UserRepository;

@Configuration
public class SeedData {

	public SeedData(BillingRecordRepository recordRepository, CompanyRepository companyRepository,
			UserRepository userRepository, PasswordEncoder./ encoder) {
		User admin = userRepository.save(new User("admin", encoder.encode("admin")));

		Company vapianos = companyRepository.save(new Company("Vapianos Ltd."));
		Company merts = companyRepository.save(new Company("Merts, LLC"));
		Company redeyediner = companyRepository.save(new Company("Red Eye Diner, LLC"));
		Company aria = companyRepository.save(new Company("Aria, LLC"));
		Company pinkysgrill = companyRepository.save(new Company("Pinky's Grill, LLC"));
		Company salspizza = companyRepository.save(new Company("Sal's Pizza, LLC"));
		Company selenium = companyRepository.save(new Company("Selenium, LLC"));
		Company zentaco = companyRepository.save(new Company("Zen Taco, LLC"));
		Company bbb = companyRepository.save(new Company("Big Baller Brand, LLC"));

		recordRepository.save(new FlatFeeBillingRecord(300, "Faxes", vapianos, admin));
		recordRepository.save(new FlatFeeBillingRecord(1.75, "Socks", redeyediner, admin));
		recordRepository.save(new FlatFeeBillingRecord(500, "Paper", merts, admin));
		recordRepository.save(new FlatFeeBillingRecord(72.33, "Stockings", aria, admin));
		recordRepository.save(new FlatFeeBillingRecord(142.99, "Paint", redeyediner, admin));
		recordRepository.save(new FlatFeeBillingRecord(300, "Faxes", vapianos, admin));
		recordRepository.save(new FlatFeeBillingRecord(1.75, "Socks", aria, admin));
		recordRepository.save(new FlatFeeBillingRecord(500, "Paper", selenium, admin));
		recordRepository.save(new FlatFeeBillingRecord(72.33, "Stockings", merts, admin));
		recordRepository.save(new FlatFeeBillingRecord(142.99, "Paint", zentaco, admin));
		recordRepository.save(new FlatFeeBillingRecord(300, "Faxes", salspizza, admin));
		recordRepository.save(new FlatFeeBillingRecord(1.75, "Socks", aria, admin));
		recordRepository.save(new FlatFeeBillingRecord(500, "Paper", redeyediner, admin));
		recordRepository.save(new FlatFeeBillingRecord(72.33, "Stockings", bbb, admin));
		recordRepository.save(new FlatFeeBillingRecord(142.99, "Paint", selenium, admin));

		recordRepository.save(new RateBasedBillingRecord(500, 3.5, "Legal services", vapianos, admin));
		recordRepository.save(new RateBasedBillingRecord(150, 2.5, "Painting", redeyediner, admin));
		recordRepository.save(new RateBasedBillingRecord(100, 4.25, "House cleaning", zentaco, admin));
		recordRepository.save(new RateBasedBillingRecord(700, 8, "Lighting", merts, admin));
		recordRepository.save(new RateBasedBillingRecord(1.57, 25, "Show shining", redeyediner, admin));
		recordRepository.save(new RateBasedBillingRecord(500, 3.5, "Legal services", pinkysgrill, admin));
		recordRepository.save(new RateBasedBillingRecord(150, 2.5, "Painting", aria, admin));
		recordRepository.save(new RateBasedBillingRecord(100, 4.25, "House cleaning", bbb, admin));
		recordRepository.save(new RateBasedBillingRecord(700, 8, "Lighting", selenium, admin));
		recordRepository.save(new RateBasedBillingRecord(1.57, 25, "Show shining", redeyediner, admin));
		recordRepository.save(new RateBasedBillingRecord(500, 3.5, "Legal services", salspizza, admin));
		recordRepository.save(new RateBasedBillingRecord(150, 2.5, "Painting", zentaco, admin));
		recordRepository.save(new RateBasedBillingRecord(100, 4.25, "House cleaning", salspizza, admin));
		recordRepository.save(new RateBasedBillingRecord(700, 8, "Lighting", pinkysgrill, admin));
		recordRepository.save(new RateBasedBillingRecord(1.57, 25, "Show shining", redeyediner, admin));
	}

}