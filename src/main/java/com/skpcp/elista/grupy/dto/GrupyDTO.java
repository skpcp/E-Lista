package com.skpcp.elista.grupy.dto;

import com.skpcp.elista.base.dto.BaseDTO;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by  Tomek on 2016-03-20.
 */
@ApiModel
public class GrupyDTO extends BaseDTO implements Serializable {
    private Long idUzytkownika;
    private String nazwaGrupy;

    public GrupyDTO(String nazwaGrupy, Long id) {
    }

    public GrupyDTO(Long id, Date techDate, Long idUzytkownika, String nazwaGrupy) {
        super(id,techDate);
        this.idUzytkownika = idUzytkownika;
        this.nazwaGrupy = nazwaGrupy;
    }
qq
    public Long getIdUzytkownika() {
        return idUzytkownika;
    }

    public void setIdUzytkownika(Long idUzytkownika) {
        this.idUzytkownika = idUzytkownika;
    }

    public String getNazwaGrupy() {
        return nazwaGrupy;
    }

    public void setNazwaGrupy(String nazwaGrupy) {
        this.nazwaGrupy = nazwaGrupy;
    }
}
