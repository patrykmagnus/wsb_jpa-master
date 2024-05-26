package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.MedicalTreatmentTO;
import com.capgemini.wsb.persistence.entity.MedicalTreatmentEntity;

import java.util.stream.Collectors;

public final class MedicalTreatmentMapper {

    public static MedicalTreatmentTO mapToTO(final MedicalTreatmentEntity medicalTreatmentEntity) {
        if (medicalTreatmentEntity == null) {
            return null;
        }
        final MedicalTreatmentTO medicalTreatmentTO = new MedicalTreatmentTO();
        medicalTreatmentTO.setId(medicalTreatmentEntity.getId());
        medicalTreatmentTO.setDescription(medicalTreatmentEntity.getDescription());
        medicalTreatmentTO.setType(medicalTreatmentEntity.getType());
        medicalTreatmentTO.setVisits(medicalTreatmentEntity.getVisits().stream()
                .map(VisitMapper::mapToTO)
                .collect(Collectors.toList()));
        return medicalTreatmentTO;
    }

    public static MedicalTreatmentEntity mapToEntity(final MedicalTreatmentTO medicalTreatmentTO) {
        if (medicalTreatmentTO == null) {
            return null;
        }
        MedicalTreatmentEntity medicalTreatmentEntity = new MedicalTreatmentEntity();
        medicalTreatmentEntity.setId(medicalTreatmentTO.getId());
        medicalTreatmentEntity.setDescription(medicalTreatmentTO.getDescription());
        medicalTreatmentEntity.setType(medicalTreatmentTO.getType());
        medicalTreatmentEntity.setVisits(medicalTreatmentTO.getVisits().stream()
                .map(VisitMapper::mapToEntity)
                .collect(Collectors.toList()));
        return medicalTreatmentEntity;
    }
}
