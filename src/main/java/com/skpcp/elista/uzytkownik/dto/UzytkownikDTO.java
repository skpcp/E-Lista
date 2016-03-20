package com.skpcp.elista.uzytkownik.dto;

import com.skpcp.elista.base.dto.BaseDTO;
import com.skpcp.elista.uzytkownik.EStan;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by  Tomek on 2016-03-20.
 */
@ApiModel
public class UzytkownikDTO extends BaseDTO implements Serializable{
    private String imie;
    private String nazwisko;


    public UzytkownikDTO() {
    }



    //konstruktor do userconverter
    public UzytkownikDTO(Long aId,Date aTechDate,String aImie, String aNazwisko) {
        super(aId,aTechDate);
        this.imie = aImie;
        this.nazwisko = aNazwisko;
    }



    public String getImie() {
        return imie;
    }

    public void setImie(String aImie) {
        this.imie = aImie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String aNazwisko) {
        this.nazwisko = aNazwisko;
    }


}
