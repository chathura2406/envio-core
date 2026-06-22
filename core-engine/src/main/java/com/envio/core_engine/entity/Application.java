package com.envio.core_engine.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "applications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Application {

    @Id
    @Column(length = 50, nullable = false)
    private String id; // ex: "payment-service"

    @Column(length = 100, nullable = false)
    private String name; // ex: "Payment Processing Service"
}