package com.asacoding.dolphin_architecture.domain.model.remote.cashCollection

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


data class Clinics(

    val clinics: List<Clinic>?,
) {
    @Parcelize

    data class Clinic(
        val id: Int? = null,
        val nameArabic: String? = null,
        val nameEnglish: String? = null,
        val reservationValue: Double? = null,

        ) : Parcelable
}

fun Clinics.Clinic.isDataValid(): Boolean {
    return (id != null && !nameArabic.isNullOrEmpty() && reservationValue != null)
}

fun Clinics.isDataValid(): Boolean {
    return (!clinics.isNullOrEmpty() && clinics.fold(
        true,
        operation = { prev, value -> prev && value.isDataValid() }))
}

