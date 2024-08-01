package com.asacoding.dolphin_architecture.data.remote.dto.cash_collection.cashCollection

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class ClinicSchedulesDtoRs(

    @SerializedName("data")
    val data: ScheduleDetails? = null

) {
    data class ScheduleDetails(

        @SerializedName("eventId")
        val eventID: Int,

        @SerializedName("scheduleId")
        val scheduleID: Int,

        @SerializedName("scheduleName")
        val scheduleName: String,

        @SerializedName("active")
        val active: Boolean,

        @SerializedName("timeSlots")
        val timeSlots: List<TimeSlot>,
    ) {
        @Parcelize
        data class TimeSlot(

            @SerializedName("scheduleTimeSlotId")
            val scheduleTimeSlotID: Int,

            @SerializedName("maxReservations")
            val maxReservations: Int,

            @SerializedName("reservationValue")
            val reservationValue: Double,

            @SerializedName("timeSlotLookupDetails")
            val lookupDetails: LookupDetails,

            ) : Parcelable {
            @Parcelize
            data class LookupDetails(

                @SerializedName("id")
                val id: Int,

                @SerializedName("dayOfWeek")
                val dayOfWeek: String,

                @SerializedName("weekDayId")
                val weekDayID: Int,

                @SerializedName("fromTime")
                val fromTime: String,

                @SerializedName("toTime")
                val toTime: String,

                @SerializedName("active")
                val active: Boolean,
            ) : Parcelable

            override fun toString(): String =
                "${lookupDetails.dayOfWeek} : from ${lookupDetails.fromTime} to ${lookupDetails.toTime}"

        }
    }
}