package com.asacoding.dolphin_architecture.domain.mapper.reporting


import com.asacoding.dolphin_architecture.data.remote.dto.reporting.ReportDtoRs
import com.asacoding.dolphin_architecture.domain.model.remote.reporting.DailyReport


class DailyReportRsMapper {
    fun buildFrom(reportDtoRs: ReportDtoRs): DailyReport {
        return DailyReport(
            status = DailyReport.Status(reportDtoRs.status?.code, reportDtoRs.status?.msg),
            numOfTransactions = reportDtoRs.numOfTransactions,
            totalAmount = reportDtoRs.totalAmount,
        )
    }
}

