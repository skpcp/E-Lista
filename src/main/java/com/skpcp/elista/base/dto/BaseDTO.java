package com.skpcp.elista.base.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by  Tomek on 2016-03-20.
 */

public abstract class BaseDTO implements Serializable {
    private Long id;
    private Date techDate;

    public BaseDTO() { // Konstrukto bezargumentowy ważny! musi być w każdej klasie DTO
    }

    public BaseDTO(Long id, Date techDate) {
        this.id = id;
        this.techDate = techDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTechDate() {
        return techDate;
    }

    public void setTechDate(Date techDate) {
        this.techDate = techDate;
    }
}
