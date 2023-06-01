package org.krejo;

import org.krejo.data.AddressDataService;
import org.krejo.data.StoreDataService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    public StoreDataService createStoreDataService() {
        StoreDataService d = new StoreDataService();
        return d;
    }

    @Bean
    public AddressDataService createAddressDataService() {
        AddressDataService d = new AddressDataService();
        return d;
    }
}
