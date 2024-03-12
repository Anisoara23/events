package com.example.events.customer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class CustomerRegisteredEvent {

    private final Customer customer;
}
