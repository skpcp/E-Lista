package com.skpcp.elista.rola.dto;

import io.swagger.annotations.ApiModel;

/**
 * Created by Tomasz Komoszeski on 2016-05-08.
 */
@ApiModel
public class RolaDTOZmiana {
    private String rola;
    private String rolaDoZmiany;

    public RolaDTOZmiana() {
    }

    public RolaDTOZmiana(String rola, String rolaDoZmiany) {
        this.rola = rola;
        this.rolaDoZmiany = rolaDoZmiany;
    }

    public String getRola() {
        return rola;
    }

    public void setRola(String rola) {
        this.rola = rola;
    }

    public String getRolaDoZmiany() {
        return rolaDoZmiany;
    }

    public void setRolaDoZmiany(String rolaDoZmiany) {
        this.rolaDoZmiany = rolaDoZmiany;
    }
}
