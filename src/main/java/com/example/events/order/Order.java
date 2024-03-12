package com.example.events.order;

import com.example.events.customer.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    private OrderStatus status;

    @Column(length = 40)
    private String message;

    @ManyToOne
    private Customer customer;

    public Order(OrderStatus status) {
        this.status = status;
    }

    public enum OrderStatus {
        SAVED, COMPLETED
    }

}
