package com.skpcp.elista.uzytkownik_grupy.dto;

import com.skpcp.elista.base.dto.BaseDTO;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by  Tomek on 2016-03-20.
 */
@ApiModel
public class UzytkownikGrupyDTO extends BaseDTO implements Serializable {
    private Long idUzytkownika;
    private Long idGrupy;

    public UzytkownikGrupyDTO() {
    }

    public UzytkownikGrupyDTO(Long id, Date techDate, Long idUzytkownika, Long idGrupy) {
        super(id,techDate);
        this.idUzytkownika = idUzytkownika;
        this.idGrupy = idGrupy;
    }

    public Long getIdUzytkownika() {
        return idUzytkownika;
    }

    public void setIdUzytkownika(Long idUzytkownika) {
        this.idUzytkownika = idUzytkownika;
    }

    public Long getIdGrupy() {
        return idGrupy;
    }

    public void setIdGrupy(Long idGrupy) {
        this.idGrupy = idGrupy;
    }
}
