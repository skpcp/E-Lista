package com.skpcp.elista.nieobecnosci.dto;

import com.skpcp.elista.base.dto.BaseDTO;
import com.skpcp.elista.nieobecnosci.EJednostka;
import io.swagger.annotations.ApiModel;

import java.util.Date;

/**
 * Created by  Tomek on 2016-03-20.
 */
@ApiModel
public class NieobecnosciDTO extends BaseDTO {
    private Long idUzytkownika;
    private Date data;
    private Long ilosc;
    private EJednostka typ;

    public NieobecnosciDTO() {
    }

    public NieobecnosciDTO(Long id, Date techDate, Long idUzytkownika, Date data, Long ilosc, EJednostka typ) {
        super(id, techDate);
        this.idUzytkownika = idUzytkownika;
        this.data = data;
        this.ilosc = ilosc;
        this.typ = typ;
    }

    public Long getIdUzytkownika() {
        return idUzytkownika;
    }

    public void setIdUzytkownika(Long idUzytkownika) {
        this.idUzytkownika = idUzytkownika;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Long getIlosc() {
        return ilosc;
    }

    public void setIlosc(Long ilosc) {
        this.ilosc = ilosc;
    }

    public EJednostka getTyp() {
        return typ;
    }

    public void setTyp(EJednostka typ) {
        this.typ = typ;
    }


}
