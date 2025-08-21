package com.dgMarket.auction;

import com.dgMarket.auction.shared.config.JpaAuditingConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(JpaAuditingConfig.class)
public class BidManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BidManagementSystemApplication.class, args);
	}

}
