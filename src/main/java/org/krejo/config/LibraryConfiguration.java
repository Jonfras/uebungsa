package org.krejo.config;

import org.krejo.data.services.AddressDataService;
import org.krejo.data.services.BookDataService;
import org.krejo.data.services.LibraryDataService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LibraryConfiguration {
    @Bean
    public BookDataService createBookDataService() {
        return new BookDataService();
    }
    @Bean
    public LibraryDataService createLibraryDataService() {
        return new LibraryDataService();
    }
    @Bean
    public AddressDataService createAddressDataService() {
        return new AddressDataService();
    }
}
