package com.example.convergenceintegration.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "target_system")
public class TargetSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "system_name", nullable = false, unique = true)
    private String systemName;

    @Column(name = "api_endpoint")
    private String apiEndpoint;

    @Column(name = "data_format")
    private String dataFormat;

    // No-arg constructor
    public TargetSystem() {}

    // All-args constructor
    public TargetSystem(Long id, String systemName, String apiEndpoint, String dataFormat) {
        this.id = id;
        this.systemName = systemName;
        this.apiEndpoint = apiEndpoint;
        this.dataFormat = dataFormat;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getApiEndpoint() {
        return apiEndpoint;
    }

    public void setApiEndpoint(String apiEndpoint) {
        this.apiEndpoint = apiEndpoint;
    }

    public String getDataFormat() {
        return dataFormat;
    }

    public void setDataFormat(String dataFormat) {
        this.dataFormat = dataFormat;
    }
}
