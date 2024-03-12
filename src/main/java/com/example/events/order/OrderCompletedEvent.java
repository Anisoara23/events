package com.example.events.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class OrderCompletedEvent {

    private final Order order;
}
