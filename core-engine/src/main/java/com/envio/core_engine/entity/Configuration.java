package com.envio.core_engine.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "configurations", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"app_id", "env_id", "config_key"}) 
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Configuration {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // Many Configurations can belong to One Application
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_id", nullable = false)
    private Application application;

    // Many Configurations can belong to One Environment
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "env_id", nullable = false)
    private Environment environment;

    @Column(name = "config_key", nullable = false, length = 100)
    private String configKey; //ex: "MAX_TRANSFER_LIMIT"

    @Column(name = "config_value", nullable = false, columnDefinition = "TEXT")
    private String configValue; // ex: "10000"

    @Column(name = "is_secret")
    private boolean isSecret = false; // indicates if the value is sensitive and should be masked in responses
}