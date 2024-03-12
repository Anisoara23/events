package com.example.events.email;

import com.example.events.customer.CustomerRegisteredEvent;
import com.example.events.customer.CustomerRemovedEvent;
import com.example.events.order.OrderCompletedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class EmailListeners {

    private final EmailService emailService;

    @EventListener
    public void onRegisterEvent(CustomerRegisteredEvent event) {
        emailService.sendRegisterEmail(event.getCustomer());
    }

    @EventListener
    public void onRemoveEvent(CustomerRemovedEvent event) {
        emailService.sendCustomerRemovedEmail(event.getCustomer());
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void onOrderEvent(OrderCompletedEvent event) {
        emailService.sendOrderEmail(event.getOrder());
    }
}
