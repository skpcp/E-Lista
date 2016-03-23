package com.skpcp.elista.utils;

import com.skpcp.elista.dziennikplanow.dto.DziennikPlanowDTO;
import com.skpcp.elista.dziennikplanow.ob.DziennikPlanowOB;

/**
 * Created by bidzis on 2016-03-22.
 */
public class DziennikPlanowConverter {

        public static DziennikPlanowOB dziennikplanowDTOdoDziennikPlanowowOB(DziennikPlanowDTO aDziennikPlanowDTO){
            if(aDziennikPlanowDTO == null)//zapezpieczenie
                return null;
            return new DziennikPlanowOB(aDziennikPlanowDTO.getIdUzytkownika(),aDziennikPlanowDTO.getDzienTygodnia(),aDziennikPlanowDTO.getPlanOd(),aDziennikPlanowDTO.getPlanDo());
        }

        public static DziennikPlanowDTO dziennikplanowOBdoDziennikPlanowowDTO(DziennikPlanowOB aDziennikPlanowOB){
            if(aDziennikPlanowOB == null) return null;
            return new DziennikPlanowDTO(aDziennikPlanowOB.getId(),aDziennikPlanowOB.getTechDate(),aDziennikPlanowOB.getIdUzytkownika(),aDziennikPlanowOB.getDzienTygodnia(),aDziennikPlanowOB.getPlanOd(),aDziennikPlanowOB.getPlanDo());

        }
}
