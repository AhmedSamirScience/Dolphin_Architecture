package com.asacoding.dolphin_architecture.domain.model.remote.cashCollection

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


data class ClinicSchedules(
    val data: ScheduleDetails? = null

) {
    data class ScheduleDetails(
        val eventID: Int? = null,
        val timeSlots: List<TimeSlot>? = null,
    ) {
        @Parcelize
        data class TimeSlot(
            val scheduleTimeSlotID: Int? = null,
            val lookupDetails: LookupDetails? = null,
        ) : Parcelable {
            @Parcelize
            data class LookupDetails(
                val dayOfWeek: String? = null,
                val weekDayID: Int? = null,
                val fromTime: String? = null,
                val toTime: String? = null,
            ) : Parcelable

            override fun toString(): String =
                "${lookupDetails?.dayOfWeek} : from ${lookupDetails?.fromTime} to ${lookupDetails?.toTime}"

        }
    }
}

fun ClinicSchedules.isDataValid(): Boolean {
    return data?.eventID != null && !data.timeSlots.isNullOrEmpty() && data.timeSlots.fold(true,
        operation = { prev, value -> prev && value.isDataValid() })

}

fun ClinicSchedules.ScheduleDetails.TimeSlot.isDataValid(): Boolean {
    return scheduleTimeSlotID != null && lookupDetails?.toTime != null && lookupDetails.fromTime != null && lookupDetails.dayOfWeek != null && lookupDetails.weekDayID != null
}
