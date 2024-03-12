package com.example.events.promotion;

import com.example.events.customer.CustomerRegisteredEvent;
import com.example.events.order.OrderCompletedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PromotionListener {

    private final PromotionService promotionService;

    @EventListener(condition = "#event.customer.newsletter")
    public void onRegistrationEvent(CustomerRegisteredEvent event) {
        promotionService.applyPromotion(event.getCustomer());
    }

    @EventListener
    public void onOrderCompleteEvent(OrderCompletedEvent event) {
        promotionService.calculateRewardPoints(event.getOrder());
    }
}
