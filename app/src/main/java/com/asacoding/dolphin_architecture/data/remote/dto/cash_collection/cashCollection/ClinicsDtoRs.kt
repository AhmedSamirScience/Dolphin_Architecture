package com.asacoding.dolphin_architecture.data.remote.dto.cash_collection.cashCollection

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ClinicDtoRs(
    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("levelNo")
    val levelNumber: Int? = null,

    @SerializedName("code")
    val code: Int? = null,

    @SerializedName("nameAr")
    val nameArabic: String? = null,

    @SerializedName("nameEn")
    val nameEnglish: String? = null,

    @SerializedName("reservationLevel")
    val reservationLevel: Boolean? = null,

    @SerializedName("active")
    val active: Boolean? = null,

    @SerializedName("hidden")
    val hidden: Boolean? = null,

    @SerializedName("reservationValue")
    val reservationValue: Double? = null,

    @SerializedName("maxReservationsPerDay")
    val maxReservationsPerDay: Int? = null, ) : Parcelable
