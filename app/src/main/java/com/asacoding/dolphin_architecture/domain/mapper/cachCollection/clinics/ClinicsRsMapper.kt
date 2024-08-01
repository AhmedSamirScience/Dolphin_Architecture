package com.asacoding.dolphin_architecture.domain.mapper.cachCollection.clinics


import com.asacoding.dolphin_architecture.data.remote.dto.cash_collection.cashCollection.ClinicDtoRs
import com.asacoding.dolphin_architecture.domain.model.remote.cashCollection.Clinics

class ClinicsRsMapper {
    fun buildFrom(clinicsDtoRs: List<ClinicDtoRs>): Clinics {
        return Clinics(
            clinics = clinicsDtoRs.map { e ->
                Clinics.Clinic(
                    id = e.id,
                    nameArabic = e.nameArabic,
                    nameEnglish = e.nameEnglish,
                    reservationValue = e.reservationValue
                )
            }
        )
    }
}

