package com.asacoding.dolphin_architecture.domain.mapper.cachCollection.clinics


import com.asacoding.dolphin_architecture.data.remote.dto.cash_collection.cashCollection.ClinicSchedulesDtoRs
import com.asacoding.dolphin_architecture.domain.model.remote.cashCollection.ClinicSchedules


class ClinicSchedulesRsMapper {
    fun buildFrom(clinicSchedulesDtoRs: ClinicSchedulesDtoRs): ClinicSchedules {
        return ClinicSchedules(
            data =
            clinicSchedulesDtoRs.data?.let {
                ClinicSchedules.ScheduleDetails(
                    it.eventID,
                    it.timeSlots.map { e ->
                        ClinicSchedules.ScheduleDetails.TimeSlot(
                            e.scheduleTimeSlotID,
                            ClinicSchedules.ScheduleDetails.TimeSlot.LookupDetails(
                                e.lookupDetails.dayOfWeek,
                                e.lookupDetails.weekDayID,
                                e.lookupDetails.toTime,
                                e.lookupDetails.fromTime
                            )
                        )
                    }
                )
            }
        )
    }
}

