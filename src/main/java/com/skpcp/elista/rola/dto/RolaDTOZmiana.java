package com.skpcp.elista.rola.dto;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * Created by Tomasz Komoszeski on 2016-05-08.
 */
@ApiModel
public class RolaDTOZmiana implements Serializable {
    private Long id;
    private String rolaDoZmiany;

    public RolaDTOZmiana() {
    }

    public RolaDTOZmiana(Long id, String rolaDoZmiany) {
        this.id = id;
        this.rolaDoZmiany = rolaDoZmiany;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRolaDoZmiany() {
        return rolaDoZmiany;
    }

    public void setRolaDoZmiany(String rolaDoZmiany) {
        this.rolaDoZmiany = rolaDoZmiany;
    }
}
