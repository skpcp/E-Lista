package com.skpcp.elista.utils.converters;

import com.skpcp.elista.dziennikplanow.dto.DziennikPlanowDTO;
import com.skpcp.elista.dziennikplanow.dto.DziennikPlanowDTOBezTechDate;
import com.skpcp.elista.dziennikplanow.dto.DziennikPlanowDTOBezUzytkownika;
import com.skpcp.elista.dziennikplanow.dto.DziennikPlanowDTOUzytkownik;
import com.skpcp.elista.dziennikplanow.ob.DziennikPlanowOB;

/**
 * Created by bidzis on 2016-03-22.
 */
public class DziennikPlanowConverter {


        public static DziennikPlanowDTO dziennikplanowOBdoDziennikPlanowowDTO(DziennikPlanowOB aDziennikPlanowOB){
            if(aDziennikPlanowOB == null) return null;

            return new DziennikPlanowDTO(aDziennikPlanowOB.getId(),aDziennikPlanowOB.getTechDate(),UzytkownikConverter.uzytOBdoUzytkDTO(aDziennikPlanowOB.getUzytkownik()),aDziennikPlanowOB.getDzienTygodnia(),aDziennikPlanowOB.getPlanOd(),aDziennikPlanowOB.getPlanDo());
        }

        public static DziennikPlanowDTOUzytkownik dziennikPlanowDTOdoDziennikPlanowDTOUzytkownik(DziennikPlanowDTO aDziennikPlanowDTO){
            if(aDziennikPlanowDTO == null) return null;
            return new DziennikPlanowDTOUzytkownik(aDziennikPlanowDTO.getId(),aDziennikPlanowDTO.getTechDate(),UzytkownikConverter.uzytkownikDTOdoUzytkownikDTOBezHasla(aDziennikPlanowDTO.getUzytkownik()),aDziennikPlanowDTO.getDzienTygodnia(),aDziennikPlanowDTO.getPlanOd(),aDziennikPlanowDTO.getPlanDo());
        }

        public static DziennikPlanowDTOBezUzytkownika dziennikPlanowDTOdoDziennikPlanowDTOBezUzytkownika(DziennikPlanowDTO aDziennikPlanowDTO){
            return new DziennikPlanowDTOBezUzytkownika(aDziennikPlanowDTO.getId(),aDziennikPlanowDTO.getTechDate(), aDziennikPlanowDTO.getDzienTygodnia(),aDziennikPlanowDTO.getPlanOd(),aDziennikPlanowDTO.getPlanDo());
        }

        public static DziennikPlanowDTOBezTechDate dziennikPlanowDTOdoDziennikPlanowDTOBezTechDate(DziennikPlanowDTO aDziennikPlanowDTO){
            if(aDziennikPlanowDTO == null) return null;
            return new DziennikPlanowDTOBezTechDate(aDziennikPlanowDTO.getId(),UzytkownikConverter.uzytkownikDTOdoUzytkownikDTOEmial(aDziennikPlanowDTO.getUzytkownik()),aDziennikPlanowDTO.getPlanOd(),aDziennikPlanowDTO.getPlanDo());
        }
}
