package org.eddytucubal.dex_db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DexDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(DexDbApplication.class, args);
	}

}
