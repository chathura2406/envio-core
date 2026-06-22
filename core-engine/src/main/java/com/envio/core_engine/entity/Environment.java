package com.envio.core_engine.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "environments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Environment {

    @Id
    @Column(length = 20, nullable = false)
    private String id; //ex: "dev" , "prod"

    @Column(length = 50, nullable = false)
    private String name; //ex: "Development" , "Production"
}