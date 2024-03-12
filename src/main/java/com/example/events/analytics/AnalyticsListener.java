package com.example.events.analytics;

import com.example.events.customer.CustomerRegisteredEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AnalyticsListener {

    public final AnalyticsService analyticsService;

    @EventListener
    @Async
    public void onCustomerRegisterEvent(CustomerRegisteredEvent event) {
        analyticsService.registerNewCustomer(event.getCustomer());
    }
}
