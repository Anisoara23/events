package com.example.events.customer;

import com.example.events.email.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final EmailService emailService;

    public void register(Customer customer) {
        customerRepository.save(customer);
        emailService.sendRegisterEmail(customer);
    }

    public void remove(Customer customer) {
        customerRepository.delete(customer);
    }
}
