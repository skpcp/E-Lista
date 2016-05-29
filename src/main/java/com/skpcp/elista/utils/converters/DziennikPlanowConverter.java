package com.skpcp.elista.utils.converters;


import com.skpcp.elista.dziennikplanow.dto.DziennikPlanowDTOBezUzytkownika;
import com.skpcp.elista.dziennikplanow.dto.DziennikPlanowDTOUzytkownik;
import com.skpcp.elista.dziennikplanow.ob.DziennikPlanowOB;

import java.text.SimpleDateFormat;

/**
 * Created by bidzis on 2016-03-22.
 */
public class DziennikPlanowConverter {

        public static DziennikPlanowDTOUzytkownik dziennikPlanowOBDoDziennikPlanowDTOUzytkownik(DziennikPlanowOB aDziennikPlanowOB){
            if(aDziennikPlanowOB == null) return null;
            SimpleDateFormat czas = new SimpleDateFormat("HH:mm");
            String rozpoczecie = czas.format(aDziennikPlanowOB.getPlanOd());
            String zakonczenie = czas.format(aDziennikPlanowOB.getPlanDo());
            return new DziennikPlanowDTOUzytkownik(aDziennikPlanowOB.getId(),aDziennikPlanowOB.getTechDate(),UzytkownikConverter.uzytkownikOBDoUzytkownikaDTOBezHasla(aDziennikPlanowOB.getUzytkownik()),aDziennikPlanowOB.getDzienTygodnia(),rozpoczecie,zakonczenie);
        }

        public static DziennikPlanowDTOBezUzytkownika dziennikPlanowOBDodziennikPlanowDTOBezUzytkownika(DziennikPlanowOB aDziennikPlanowOB){
            if(aDziennikPlanowOB == null) return null;
            SimpleDateFormat czas = new SimpleDateFormat("HH:mm");
            String rozpoczecie = czas.format(aDziennikPlanowOB.getPlanOd());
            String zakonczenie = czas.format(aDziennikPlanowOB.getPlanDo());
            return new DziennikPlanowDTOBezUzytkownika(aDziennikPlanowOB.getId(),aDziennikPlanowOB.getTechDate(),aDziennikPlanowOB.getDzienTygodnia(),rozpoczecie,zakonczenie);
        }
}
