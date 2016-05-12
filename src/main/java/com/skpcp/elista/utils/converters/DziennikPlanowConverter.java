package com.skpcp.elista.utils.converters;


import com.skpcp.elista.dziennikplanow.dto.DziennikPlanowDTOBezUzytkownika;
import com.skpcp.elista.dziennikplanow.dto.DziennikPlanowDTOUzytkownik;
import com.skpcp.elista.dziennikplanow.ob.DziennikPlanowOB;

/**
 * Created by bidzis on 2016-03-22.
 */
public class DziennikPlanowConverter {

        public static DziennikPlanowDTOUzytkownik dziennikPlanowOBDoDziennikPlanowDTOUzytkownik(DziennikPlanowOB aDziennikPlanowOB){
            if(aDziennikPlanowOB == null) return null;
            return new DziennikPlanowDTOUzytkownik(aDziennikPlanowOB.getId(),aDziennikPlanowOB.getTechDate(),UzytkownikConverter.uzytkownikOBDoUzytkownikaDTOBezHasla(aDziennikPlanowOB.getUzytkownik()),aDziennikPlanowOB.getDzienTygodnia(),aDziennikPlanowOB.getPlanOd(),aDziennikPlanowOB.getPlanDo());
        }

        public static DziennikPlanowDTOBezUzytkownika dziennikPlanowOBDodziennikPlanowDTOBezUzytkownika(DziennikPlanowOB aDziennikPlanowOB){
            if(aDziennikPlanowOB == null) return null;
            return new DziennikPlanowDTOBezUzytkownika(aDziennikPlanowOB.getId(),aDziennikPlanowOB.getTechDate(),aDziennikPlanowOB.getDzienTygodnia(),aDziennikPlanowOB.getPlanOd(),aDziennikPlanowOB.getPlanDo());
        }
}
