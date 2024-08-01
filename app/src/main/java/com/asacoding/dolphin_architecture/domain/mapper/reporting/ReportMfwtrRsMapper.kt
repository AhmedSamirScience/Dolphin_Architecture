package com.asacoding.dolphin_architecture.domain.mapper.reporting


import com.asacoding.dolphin_architecture.data.remote.dto.reporting.ReportDtoRs
import idhcorp.mokhtabar.chemist.domain.model.remote.reporting.ReportBiller

class ReportBillerRsMapper {
    fun buildFrom(reportDtoRs: ReportDtoRs): ReportBiller {
        return ReportBiller(
            status = ReportBiller.Status(reportDtoRs.status?.code, reportDtoRs.status?.msg),
            posSerialNumber = reportDtoRs.posSerialNumber,
            numOfTransactions = reportDtoRs.numOfTransactions,
            totalAmount = reportDtoRs.totalAmount,
        )
    }
}

